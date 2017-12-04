package com.example.ghch9.eva2_08_listas;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Secundaria extends AppCompatActivity implements ListView.OnItemClickListener{

    ListView listView_objetos;
    Intent intent_datos;
    String[] datos = {"tacos","tortillas", "tostadas", "discada", "chuletas", "huerfanos?"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secundaria);
        listView_objetos = (ListView)findViewById(R.id.listView_objetos);
        listView_objetos.setAdapter(new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, datos));
        intent_datos = getIntent();
        listView_objetos.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        intent_datos.putExtra("DATOS", datos[position]);
        setResult(Activity.RESULT_OK, intent_datos);
        finish();
    }
}
