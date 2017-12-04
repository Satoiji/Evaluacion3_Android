package com.example.ghch9.eva2_06_bundles_servicat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Main extends AppCompatActivity {

    EditText editText_nombre, editText_apellido, editText_edad, editText_salario;
    RadioButton radioButton_hombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText_nombre = (EditText)findViewById(R.id.editText_nombre);
        editText_apellido = (EditText)findViewById(R.id.editText_apellido);
        editText_edad = (EditText)findViewById(R.id.editText_edad);
        editText_salario = (EditText)findViewById(R.id.editText_salario);
        radioButton_hombre = (RadioButton)findViewById(R.id.radioButton_hombre);
    }

    public void enviarDatos(View v){
        Intent intent_enviarDatos = new Intent(this,Secundaria.class);
        Bundle bundle_datos = new Bundle();
        bundle_datos.putString("NOMBRE", editText_nombre.getText().toString());
        bundle_datos.putString("APELLIDO", editText_apellido.getText().toString());
        bundle_datos.putInt("EDAD", Integer.parseInt(editText_edad.getText().toString()));
        bundle_datos.putDouble("SALARIO", Double.parseDouble(editText_salario.getText().toString()));
        bundle_datos.putBoolean("GENERO", radioButton_hombre.isChecked());
        intent_enviarDatos.putExtras(bundle_datos);
        startActivity(intent_enviarDatos);
    }
}
