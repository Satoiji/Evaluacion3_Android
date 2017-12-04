package com.example.ghch9.eva2_04_intentos_parametros_2_servicat;

import android.app.DownloadManager;
import android.app.SearchManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Main extends AppCompatActivity {

    EditText editText_busqueda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText_busqueda = (EditText)findViewById(R.id.editText_busqueda);
    }

    public void buscar(View v){
        String cadenaBuscar = editText_busqueda.getText().toString();
        Intent intent_web = new Intent(Intent.ACTION_WEB_SEARCH);
        intent_web.putExtra(SearchManager.QUERY, cadenaBuscar);
        startActivity(intent_web);
    }
}
