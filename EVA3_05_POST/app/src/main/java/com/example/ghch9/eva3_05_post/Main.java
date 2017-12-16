package com.example.ghch9.eva3_05_post;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Main extends AppCompatActivity {

    TextView textView_datos;
    boolean destruir = false;
    String mens;
    Handler manejador = new Handler();
    Runnable runUI = new Runnable(){
        @Override
        public void run(){
            Log.e("A","still running");
            textView_datos.append(mens);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView_datos = (TextView)findViewById(R.id.textView_datos);
        Runnable datos = new Runnable(){
            @Override
            public void run(){
                int i = 0;
                while(true){
                    try{
                        //textView_datos.append(i + " - ");
                        mens = i + " - ";
                        manejador.post(runUI);
                        Thread.sleep(1000);
                        i++;
                        if(destruir)
                            break;
                    } catch(Exception e){}
                }
            }
        };

        Thread runDatos = new Thread(datos);
        runDatos.start();
    }

    @Override
    protected void onStop(){
        super.onStop();
        destruir = true;
    }
}
