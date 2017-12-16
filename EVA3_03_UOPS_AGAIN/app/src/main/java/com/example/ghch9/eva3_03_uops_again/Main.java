package com.example.ghch9.eva3_03_uops_again;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Main extends AppCompatActivity {

    TextView textView_datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView_datos = (TextView)findViewById(R.id.textView_datos);
        Runnable datos = new Runnable(){
            @Override
            public void run(){
                int i = 0;
                try {
                    while(true){
                        textView_datos.append(i + " - ");
                        Thread.sleep(1000);
                        i++;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Toast.makeText(Main.this, "No se puede modificar un view del hilo principal", Toast.LENGTH_SHORT).show();
                }
            }
        };

        new Thread(datos).start();
    }
}
