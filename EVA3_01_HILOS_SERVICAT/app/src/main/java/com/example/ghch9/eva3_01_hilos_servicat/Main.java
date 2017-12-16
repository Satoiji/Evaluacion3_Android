package com.example.ghch9.eva3_01_hilos_servicat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Runnable hilo = new Runnable(){

            @Override
            public void run() {
                while(true){
                    Log.e("HILO","IMPRIMIENDO");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Thread thread = new Thread(hilo);
        thread.start();

        Thread thread2 = new Thread(){
            @Override
            public void run() {
                super.run();
                while(true){
                    Log.e("HILO2","IMPRIMIENDO");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        thread2.start();
    }
}
