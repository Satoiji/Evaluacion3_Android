package com.example.ghch9.eva3_13_media_player_servicio;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

public class mediaPlayer extends Service {
    MediaPlayer reproductor;

    public mediaPlayer() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        reproductor = MediaPlayer.create(getApplicationContext(), R.raw.boring);
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        if(reproductor != null)
            reproductor.start();
        Toast.makeText(this, "reproduciendo cancion", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(reproductor != null){
            reproductor.stop();
            reproductor.release();
        }
    }
}
