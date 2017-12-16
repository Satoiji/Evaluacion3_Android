package com.example.ghch9.eva3_02_uops_hilos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        classThread hilo = new classThread();
        //hilo.run(); //manda a llamar la clase run
        hilo.start(); //ejecuta el run usando hilo de ejecución

        classRunnable hilo2 = new classRunnable();
        Thread thread = new Thread(hilo2);
        thread.start();
    }
}
