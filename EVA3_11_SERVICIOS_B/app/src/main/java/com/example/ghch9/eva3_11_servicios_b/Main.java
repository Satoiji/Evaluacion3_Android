package com.example.ghch9.eva3_11_servicios_b;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main extends AppCompatActivity {

    BroadcastReceiver broadcast;
    TextView textView_resultados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView_resultados = (TextView)findViewById(R.id.textView_resultados);

        IntentFilter filtro = new IntentFilter("FILTRO1");
        broadcast = new BroadcastReceiver1();
        registerReceiver(broadcast, filtro);
    }
}
