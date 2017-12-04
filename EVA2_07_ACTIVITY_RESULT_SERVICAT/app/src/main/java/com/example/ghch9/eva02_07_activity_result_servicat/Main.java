package com.example.ghch9.eva02_07_activity_result_servicat;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Main extends AppCompatActivity {

    private final int DATOS = 1000;
    private final int CONTACTOS = 2000;
    TextView textView_datos;
    Intent intent_datos, intent_contactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView_datos = (TextView)findViewById(R.id.textView_datos);
        intent_datos = new Intent(this,Secundaria.class);
        Uri uri_contacto = ContactsContract.Contacts.CONTENT_URI;
        intent_contactos = new Intent(Intent.ACTION_PICK, uri_contacto);
    }

    public void recuperarDatos(View v){
        startActivityForResult(intent_datos,DATOS);
    }

    public void recuperarContacto(View v){
        startActivityForResult(intent_contactos,CONTACTOS);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == DATOS){
            if (resultCode == Activity.RESULT_OK)
                textView_datos.setText(data.getStringExtra("DATOS"));
        } else if (requestCode == CONTACTOS){
            if (resultCode == Activity.RESULT_OK){
                String contacto = data.getDataString();
                Intent intent_editarContacto = new Intent(Intent.ACTION_EDIT, Uri.parse(contacto));
                startActivity(intent_editarContacto);
            }
        }
    }
}
