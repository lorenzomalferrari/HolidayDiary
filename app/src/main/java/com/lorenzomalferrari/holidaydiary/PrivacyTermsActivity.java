package com.lorenzomalferrari.holidaydiary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PrivacyTermsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy_terms);
        this.setTitle(R.string.privacytermsofuse);
    }
}
