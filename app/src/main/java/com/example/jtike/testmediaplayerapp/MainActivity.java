package com.example.jtike.testmediaplayerapp;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    boolean isPaused;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button pauseButton = (Button)findViewById(R.id.pause_button);
        Button playButton = (Button)findViewById(R.id.startButton);

        pauseButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                pauseSong(v);            }
        });

        playButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                StartSong(v);
            }

        });

        mediaPlayer = MediaPlayer.create(this,R.raw.pbjtsong);
        isPaused = false;

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                View gifView = findViewById(R.id.pbjtGif);
                Toast toast = Toast.makeText(getApplicationContext(),"Song Complete",Toast.LENGTH_SHORT);
                toast.show();
                gifView.setVisibility(View.INVISIBLE);
            }
        });
    }


    public void pauseSong(View view) {

        View gifView = findViewById(R.id.pbjtGif);


        if(!isPaused){
            isPaused = true;
            gifView.setVisibility(View.INVISIBLE);
            mediaPlayer.pause();
        }
        else
        {
            isPaused = false;
            gifView.setVisibility(View.VISIBLE);
            mediaPlayer.start();
        }
    }

    public void StartSong(View view) {
        Button pauseButton = findViewById(R.id.pause_button);

        View gifView = findViewById(R.id.pbjtGif);

        pauseButton.setVisibility(View.VISIBLE);

        gifView.setVisibility(View.VISIBLE);

        mediaPlayer.start();

    }
}
