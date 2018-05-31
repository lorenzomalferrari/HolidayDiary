package com.lorenzomalferrari.holidaydiary.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.lorenzomalferrari.holidaydiary.R;

/**
 *
 * @author Lorenzo Malferrari - Website: www.lorenzomalferrari.com
 */
public class PrivacyTermsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy_terms);
        getSupportActionBar().setTitle(R.string.privacyterms_title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
