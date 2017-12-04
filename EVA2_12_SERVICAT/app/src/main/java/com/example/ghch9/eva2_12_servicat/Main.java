package com.example.ghch9.eva2_12_servicat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Main extends AppCompatActivity {

    EditText editText_numero;
    Intent intent_llamada;
    boolean permiso = false;
    final int PERMISO = 1000;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText_numero = (EditText)findViewById(R.id.editText_numero);
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
            //PEDIR PERMISO
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE},PERMISO);
        } else {
            permiso = true;
        }
    }
    
    public void llamar(View v){
        if (permiso){
            String telefono = "tel:" + editText_numero.getText().toString();
            intent_llamada = new Intent(Intent.ACTION_CALL, Uri.parse(telefono));
            startActivity(intent_llamada);
        } else {
            Toast.makeText(this, "No se tienen permisos para hacer la llamada", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISO){
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED)
                permiso = true;
            else
                Toast.makeText(this, "No se brindaron los permisos para hacer la llamada", Toast.LENGTH_SHORT).show();
        }
    }
}
