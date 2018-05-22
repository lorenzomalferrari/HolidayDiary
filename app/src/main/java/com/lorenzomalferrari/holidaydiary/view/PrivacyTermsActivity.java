package com.lorenzomalferrari.holidaydiary.view;

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
        //Set title with @string
        this.setTitle(getString(R.string.privacyterms_title));
    }
}
