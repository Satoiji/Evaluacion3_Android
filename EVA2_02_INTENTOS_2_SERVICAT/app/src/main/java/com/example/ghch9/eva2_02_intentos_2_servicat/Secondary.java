package com.example.ghch9.eva2_02_intentos_2_servicat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Secondary extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);
    }

    public void finalizarSecundaria(View v){
        finish();
    }
}
