package com.example.ghch9.eva3_06_banner;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class Main extends AppCompatActivity {

    boolean destruir = false;
    ImageView imageView_imagen;
    int nextView = 0;
    Handler message = new Handler(){
        @Override
        public void handleMessage(Message msg){
            super.handleMessage(msg);
            switch(nextView){
                case 0:
                    imageView_imagen.setImageResource(R.drawable.f1);
                    nextView++;
                    break;
                case 1:
                    imageView_imagen.setImageResource(R.drawable.f2);
                    nextView++;
                    break;
                default:
                    imageView_imagen.setImageResource(R.drawable.f3);
                    nextView = 0;
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView_imagen = (ImageView)findViewById(R.id.imageView_imagen);
        Thread timer = new Thread(){
            @Override
            public void run(){
                super.run();
                while(true){
                    try{
                        Message msg = message.obtainMessage();
                        message.sendMessage(msg);
                        Thread.sleep(1500);
                        if(destruir)
                            break;
                    }catch(Exception e){}
                }
            }
        };
        timer.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        destruir = true;
    }
}
