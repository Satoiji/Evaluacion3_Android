package com.example.ghch9.eva3_12_media_player;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Main extends AppCompatActivity {

    MediaPlayer reproductor;

    @Override
    protected void onStart() {
        super.onStart();
        if(reproductor != null)
            reproductor.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(reproductor != null){
            reproductor.stop();
            reproductor.release();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        reproductor = MediaPlayer.create(getApplicationContext(),R.raw.boring);
    }
}
