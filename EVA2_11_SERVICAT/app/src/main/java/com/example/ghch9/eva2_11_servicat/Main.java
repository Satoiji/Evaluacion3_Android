package com.example.ghch9.eva2_11_servicat;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main extends AppCompatActivity {

    Context context_aplicacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context_aplicacion = getApplicationContext();
    }

    public void dialogPrefabricado(View v){
        new AlertDialog.Builder(this)
                .setTitle("Cuadro de dialogo")
                .setMessage("Hola mundo")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(context_aplicacion, "Positivo", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("Nel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(context_aplicacion, "Negativo", Toast.LENGTH_SHORT).show();
                    }
                }).create().show();
    }

    public void dialogPersonalizado(View v){
        final Dialog dialogNuevo = new Dialog(this);
        dialogNuevo.setContentView(R.layout.cuadro_de_dialogo);
        TextView etiqueta = (TextView)dialogNuevo.findViewById(R.id.textView_etiqueta);
        final EditText cuadro = (EditText)dialogNuevo.findViewById(R.id.editText_texto);;
        Button boton = (Button)dialogNuevo.findViewById(R.id.button3);
        etiqueta.setText("Cuadro de dialogo");
        boton.setText("Click");
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context_aplicacion, cuadro.getText().toString(), Toast.LENGTH_SHORT).show();
                dialogNuevo.dismiss();
            }
        });
        dialogNuevo.show();
    }
}
