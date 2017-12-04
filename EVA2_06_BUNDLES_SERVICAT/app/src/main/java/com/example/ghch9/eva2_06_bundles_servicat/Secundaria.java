package com.example.ghch9.eva2_06_bundles_servicat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Secundaria extends AppCompatActivity {

    TextView textView_datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secundaria);
        textView_datos = (TextView)findViewById(R.id.textView_datos);
        Intent intent_datos = getIntent();
        Bundle bundle_datos = intent_datos.getExtras();
        textView_datos.setText("");
        textView_datos.append("" + bundle_datos.getString("NOMBRE"));
        textView_datos.append(" " + bundle_datos.getString("APELLIDO"));
        textView_datos.append("\n" + bundle_datos.getInt("EDAD"));
        textView_datos.append("\n" + bundle_datos.getDouble("SALARIO"));
        textView_datos.append("\nGENERO");
        if (bundle_datos.getBoolean("GENERO"))
            textView_datos.append("\nHOMBRE");
        else textView_datos.append("\nMUJER");
    }

    public void cerrar(View v){ finish();}
}
