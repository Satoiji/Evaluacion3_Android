package com.example.ghch9.eva2_03_intentos_paso_parametros_servicat;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Main extends AppCompatActivity {

    EditText editText_numero, editText_mensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText_numero = (EditText)findViewById(R.id.editText_numero);
        editText_mensaje = (EditText)findViewById(R.id.editText_mensaje);
    }

    public void enviarMensaje(View v){
        String numero = "smsto:" + editText_numero.getText().toString();
        String mensaje = editText_mensaje.getText().toString();
        Intent intent_enviar = new Intent(Intent.ACTION_SENDTO, Uri.parse(numero));
        intent_enviar.putExtra("sms_body",mensaje);
        startActivity(intent_enviar);
    }
}
