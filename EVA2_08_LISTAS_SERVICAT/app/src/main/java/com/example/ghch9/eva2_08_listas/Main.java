package com.example.ghch9.eva2_08_listas;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Main extends AppCompatActivity {

    TextView textView_dato;
    Intent intent_pedirDato;
    final int DATOS = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView_dato = (TextView)findViewById(R.id.textView_dato);
        intent_pedirDato = new Intent(this,Secundaria.class);
    }

    public void pedirDato(View v){
        startActivityForResult(intent_pedirDato, DATOS);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == DATOS){
            if (resultCode == Activity.RESULT_OK){
                textView_dato.setText(data.getStringExtra("DATOS"));
            }
        }
    }
}
