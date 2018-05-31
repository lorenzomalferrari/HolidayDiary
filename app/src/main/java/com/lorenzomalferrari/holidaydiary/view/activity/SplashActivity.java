package com.lorenzomalferrari.holidaydiary.view.activity;
//
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
//
import com.lorenzomalferrari.holidaydiary.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Setto il contenuto della view
        setContentView(R.layout.activity_splash);
        // Inizializzazione degli attributi
        TextView txt1 = findViewById(R.id.txtWelcomeSplash1);
        TextView txt2 = findViewById(R.id.txtWelcomeSplash2);
        TextView txt3 = findViewById(R.id.txtWelcomeSplash3);
        ImageView imgV = findViewById(R.id.imgLogoSplash);
        // Inizializzo le animazioni
        Animation welInAnimation = AnimationUtils.loadAnimation(this, R.anim.welcom_in_trasition);
        Animation appNameAnimation = AnimationUtils.loadAnimation(this, R.anim.app_name_trasition);
        Animation iconAnimation = AnimationUtils.loadAnimation(this, R.anim.icon_trasition);
        // Setto le animazioni
        txt1.setAnimation(welInAnimation);
        txt2.setAnimation(welInAnimation);
        txt3.setAnimation(appNameAnimation);
        imgV.setAnimation(iconAnimation);
        // Inizializzazione della Intenet per richiamare la prossima Activity
        final Intent intent = new Intent(this, MenuActivity.class);
        // Setto i millis per la Splash Activity
        final int time = 2500;
        // Parte il timer per la visualizzazione completa dello Splash
        Thread timer = new Thread(){
            public void run(){
                try {
                    sleep(time);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    startActivity(intent);
                    finish();
                }
            }
        };
        timer.start();
    }
}