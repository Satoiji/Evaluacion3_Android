package com.example.ghch9.eva02_07_activity_result_servicat;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Secundaria extends AppCompatActivity {

    EditText editText_enviar;
    Intent intent_resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secundaria);
        editText_enviar = (EditText)findViewById(R.id.editText_enviar);
        intent_resultado = getIntent();
    }

    public void devolver(View v){
        String datos = editText_enviar.getText().toString();
        intent_resultado.putExtra("DATOS", datos);
        setResult(Activity.RESULT_OK, intent_resultado);
        finish();
    }
}
