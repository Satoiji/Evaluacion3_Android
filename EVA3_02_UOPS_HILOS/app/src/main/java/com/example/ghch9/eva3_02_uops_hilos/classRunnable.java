package com.example.ghch9.eva3_02_uops_hilos;

import android.util.Log;

/**
 * Created by ghch9 on 11/1/2017.
 */

public class classRunnable implements Runnable {
    @Override
    public void run() {
        for(int i = 0; i < 1000; i++){
            try{
                Log.e("guorquing runnable", "tranquiqui");
                Thread.sleep(200);
            } catch(Exception e){}
        }
    }
}
