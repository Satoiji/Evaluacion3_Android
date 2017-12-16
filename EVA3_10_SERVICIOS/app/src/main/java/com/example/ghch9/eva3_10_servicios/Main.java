package com.example.ghch9.eva3_10_servicios;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main extends AppCompatActivity {

    Intent intentServicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intentServicio = new Intent(this, Servicio.class);
        startService(intentServicio);
    }

    public void detener(View v){
        stopService(intentServicio);
    }
}
