package com.example.ghch9.eva2_05_intentos_parametros_3_servicat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Secundaria extends AppCompatActivity {

    TextView textView_mensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secundaria);
        textView_mensaje = (TextView)findViewById(R.id.textView_mensaje);
        Intent intent_datos = getIntent();
        textView_mensaje.setText(intent_datos.getStringExtra("MENSAJE"));
    }
}
