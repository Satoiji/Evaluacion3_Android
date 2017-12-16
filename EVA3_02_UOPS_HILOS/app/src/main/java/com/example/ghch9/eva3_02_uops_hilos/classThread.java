package com.example.ghch9.eva3_02_uops_hilos;

import android.util.Log;

/**
 * Created by ghch9 on 11/1/2017.
 */

public class classThread extends Thread {
    @Override
    public void run() {
        super.run();
        for(int i = 0; i < 1000; i++){
            try{
                Log.e("guorquing", "tranquiqui");
                Thread.sleep(200);
            } catch(Exception e){}
        }
    }
}
