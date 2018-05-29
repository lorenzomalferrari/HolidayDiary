package com.lorenzomalferrari.holidaydiary.view;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.lorenzomalferrari.holidaydiary.R;

public class SplashActivity extends AppCompatActivity {

    private TextView txt1, txt2, txt3;
private ImageView imgV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        txt1 = findViewById(R.id.txtWelcomeSplash1);
        txt2 = findViewById(R.id.txtWelcomeSplash2);
        txt3 = findViewById(R.id.txtWelcomeSplash3);
        imgV = findViewById(R.id.imgLogoSplash);
        Animation welInAnimation = AnimationUtils.loadAnimation(this, R.anim.welcom_in_trasition);
        Animation appNameAnimation = AnimationUtils.loadAnimation(this, R.anim.app_name_trasition);
        Animation iconAnimation = AnimationUtils.loadAnimation(this, R.anim.icon_trasition);
        txt1.setAnimation(welInAnimation);
        txt2.setAnimation(welInAnimation);
        txt3.setAnimation(appNameAnimation);
        imgV.setAnimation(iconAnimation);
        final Intent i = new Intent(this, MenuActivity.class);
        Thread timer = new Thread(){
            public void run(){
                try {
                    sleep(2500);
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