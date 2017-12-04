package com.example.ghch9.eva2_1_intentos;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Main extends AppCompatActivity {

    EditText editText_numero;
    Intent intent_llamar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText_numero = (EditText)findViewById(R.id.editText_numero);
    }

    public void llamar(View v){
        String uriCadena = "tel:" + editText_numero.getText().toString();
        intent_llamar = new Intent(Intent.ACTION_CALL, Uri.parse(uriCadena));
        startActivity(intent_llamar);
    }
}
