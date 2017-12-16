package com.example.ghch9.eva3_09_banner_async;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Toast;

public class Main extends AppCompatActivity{

    int image = 0;
    ImageView imageView_banner;
    SeekBar seekBar_velocidad;
    boolean destruir = false;
    Async banner = new Async();
    int delay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView_banner = (ImageView)findViewById(R.id.imageView_banner);
        seekBar_velocidad = (SeekBar)findViewById(R.id.seekBar_velocidad);
        seekBar_velocidad.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                delay = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        delay = seekBar_velocidad.getProgress();
        banner.execute();


    }

    private class Async extends AsyncTask<Void, Void, Void>{

        @Override
        protected Void doInBackground(Void... params) {
            while(true){
                try{
                    Thread.sleep(1000 - delay*8);
                    publishProgress();
                    if(destruir) break;
                }catch(Exception e){}
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
            switch (image) {
                case 0:
                    image++;
                    imageView_banner.setImageResource(R.drawable.f1);
                    break;
                case 1:
                    image++;
                    imageView_banner.setImageResource(R.drawable.f2);
                    break;
                default:
                    image = 0;
                    imageView_banner.setImageResource(R.drawable.f3);
                    break;
            }
        }

    }

    @Override
    protected void onStop() {
        super.onStop();
        destruir = true;
    }
}
