package com.example.ghch9.eva3_11_servicios_a;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class service extends Service {

    Intent intentDatos;
    boolean bandera = false;

    @Override
    public void onDestroy() {
        super.onDestroy();
        bandera = true;
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        Thread hilo = new Thread(){
            public void Run() throws InterruptedException {
                while(true){
                    intentDatos = new Intent("FILTRO1");
                    intentDatos.putExtra("MENSAJE", "servicio - corriendo");
                    sendBroadcast(intentDatos);
                    Thread.sleep(1000);
                    if(bandera) break;
                }
            }
        };
        hilo.start();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        intentDatos = new Intent("FILTRO1");
        intentDatos.putExtra("MENSAJE", "servicio - creado");
        sendBroadcast(intentDatos);
    }

    public service() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
