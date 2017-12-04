package com.example.ghch9.eva2_02_intentos_2_servicat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main extends AppCompatActivity {

    Intent intent_lanzarSecundaria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent_lanzarSecundaria = new Intent(this, Secondary.class);
    }

    public void ejecutarSecundaria(View v){
        startActivity(intent_lanzarSecundaria);
    }
}
