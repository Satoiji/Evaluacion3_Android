package com.example.ghch9.eva3_13_media_player_servicio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main extends AppCompatActivity {

    Intent cancionServicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cancionServicio = new Intent(this, mediaPlayer.class);
        startService(cancionServicio);
    }

    public void click(View v){
        try{
            stopService(cancionServicio);
        } catch(Exception e){}
    }
}
