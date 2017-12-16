package com.example.ghch9.eva3_11_servicios_b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by ghch9 on 12/1/2017.
 */

public class BroadcastReceiver1 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String cadenaRecibida = intent.getStringExtra("MENSAJE");
        //textView_resultados.append(cadenaRecibida + "\n");
    }
}
