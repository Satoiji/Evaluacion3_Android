package com.example.ghch9.eva3_11_servicios_a;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main extends AppCompatActivity {

    Intent intentServicio;
    BroadcastReceiver broadcast;
    TextView textView_resultados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView_resultados = (TextView)findViewById(R.id.textView_resultados);
        intentServicio = new Intent(this, service.class);
        startService(intentServicio);
        IntentFilter filtro = new IntentFilter("FILTRO1");
        broadcast = new BroadcastReceiver1();
        registerReceiver(broadcast, filtro);
    }
}
