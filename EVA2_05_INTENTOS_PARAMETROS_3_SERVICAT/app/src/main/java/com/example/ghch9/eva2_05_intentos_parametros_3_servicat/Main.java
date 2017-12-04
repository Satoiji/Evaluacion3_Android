package com.example.ghch9.eva2_05_intentos_parametros_3_servicat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Main extends AppCompatActivity {

    EditText editText_mensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText_mensaje = (EditText)findViewById(R.id.editText_mensaje);
    }

    public void enviarMensaje(View v){
        Intent intent_mensaje = new Intent(this,Secundaria.class);
        String mensaje = editText_mensaje.getText().toString();
        intent_mensaje.putExtra("MENSAJE",mensaje);
        startActivity(intent_mensaje);
    }
}
