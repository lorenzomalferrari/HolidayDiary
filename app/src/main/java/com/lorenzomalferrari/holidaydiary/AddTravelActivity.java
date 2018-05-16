package com.lorenzomalferrari.holidaydiary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class AddTravelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_travel);
        //Cambio il titolo della Activity
        this.setTitle("Add Travel");
    }
}
