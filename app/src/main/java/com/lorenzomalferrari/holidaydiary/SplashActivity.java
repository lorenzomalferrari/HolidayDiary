package com.lorenzomalferrari.holidaydiary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    private TextView txt;
    private ImageView imgV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        txt = findViewById(R.id.txtWelcomeSplash);
        imgV = findViewById(R.id.imgLogoSplash);
        Animation myAnimation = AnimationUtils.loadAnimation(this,R.anim.mytrasition);
        txt.setAnimation(myAnimation);
        imgV.setAnimation(myAnimation);
        final Intent i = new Intent(this,LoginActivity.class);
        Thread timer = new Thread(){
            public void run(){
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    startActivity(i);
                    finish();
                }
            }
        };
        timer.start();
    }
}
