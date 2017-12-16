package com.example.ghch9.eva3_practica_camara;

import android.hardware.Camera;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener{

    SeekBar tiempo;
    TextView t;
    private static final int MEDIA_TYPE_IMAGE = 1;
    private android.hardware.Camera mCamera;
    private CameraPreview mPreview;
    FrameLayout preview;
    Button captureButton, button_temporizador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_temporizador = (Button)findViewById(R.id.button_temporizador);
        mCamera = getCameraInstance();
        tiempo = (SeekBar)findViewById(R.id.seekBar);
        t = (TextView)findViewById(R.id.textView_segundos);
        tiempo.setOnSeekBarChangeListener(this);
        mPreview = new CameraPreview(this, mCamera);
        FrameLayout preview = (FrameLayout) findViewById(R.id.camera_preview);
        captureButton = (Button)findViewById(R.id.button_capture);
        preview.addView(mPreview);

        captureButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // get an image from the camera
                        mCamera.takePicture(null, null, mPicture);
                    }
                }
        );
    }

    final android.hardware.Camera.PictureCallback mPicture = new android.hardware.Camera.PictureCallback() {
        @Override
        public void onPictureTaken(byte[] data, android.hardware.Camera camera) {
            File pictureFile = getOutputMediaFile(MEDIA_TYPE_IMAGE);
            if (pictureFile == null){
                Log.d("Principal", "Error creating media file, check storage permissions: ");
                return;
            }

            try {
                Toast.makeText(Main.this, "Guardando foto", Toast.LENGTH_SHORT).show();
                FileOutputStream fos = new FileOutputStream(pictureFile);
                fos.write(data);
                fos.close();
            } catch (FileNotFoundException e) {
            } catch (IOException e) {
            } finally {
                mCamera.stopPreview();
                mCamera.startPreview();
            }
        }
    };

    public void temporizador(View v){
        Runnable hilo = new Runnable() {
            @Override
            public void run() {
                int time = Integer.parseInt(t.getText().toString());
                try {
                    Thread.sleep(time * 1000);
                    mCamera.takePicture(null, null, mPicture);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread temporizador = new Thread(hilo);
        temporizador.start();
    }

    public static android.hardware.Camera getCameraInstance(){
        android.hardware.Camera c = null;
        try {
            c = android.hardware.Camera.open();
        }
        catch (Exception e){
        }
        return c;
    }

    private static File getOutputMediaFile(int type){
        File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), "MyCameraApp");
        if (! mediaStorageDir.exists()){
            if (! mediaStorageDir.mkdirs()){
                return null;
            }
        }

        // Create a media file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File mediaFile;
        if (type == MEDIA_TYPE_IMAGE){
            mediaFile = new File(mediaStorageDir.getPath() + File.separator +
                    "IMG_"+ timeStamp + ".jpg");
        } else {
            return null;
        }

        return mediaFile;
    }

    @Override
    protected void onPause() {
        super.onPause();
        mCamera.release();

    }

    @Override
    protected void onStop() {
        super.onStop();
        mCamera.release();
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        progress+=1;
        t.setText("" + progress);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
