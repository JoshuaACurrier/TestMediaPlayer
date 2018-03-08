package com.example.jtike.testmediaplayerapp;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    boolean isPaused;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(this,R.raw.pbjtsong);
        isPaused = false;
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
