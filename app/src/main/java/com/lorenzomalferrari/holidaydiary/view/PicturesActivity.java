package com.lorenzomalferrari.holidaydiary.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.lorenzomalferrari.holidaydiary.R;

public class PicturesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pictures);
        //Set title with @string
        this.setTitle("Pictures");
    }
}
