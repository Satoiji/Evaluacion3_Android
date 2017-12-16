package com.example.ghch9.eva3_10_servicios;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class Servicio extends Service {
    public Servicio() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onStart(Intent intent, int startId) {
        Toast.makeText(this, "Iniciado", Toast.LENGTH_SHORT).show();
        super.onStart(intent, startId);
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "Destruido", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }

    @Override
    public void onCreate() {
        Toast.makeText(this, "Creado", Toast.LENGTH_SHORT).show();
        super.onCreate();
    }
}
