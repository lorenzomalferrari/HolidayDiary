package com.lorenzomalferrari.holidaydiary.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;

import com.lorenzomalferrari.holidaydiary.R;

import java.util.Date;

public class AccountActivity extends AppCompatActivity {

    EditText firstName, lastName, username, email, password, city, country, birthdate;
    RadioButton gender;
    ImageView imgUser;
    private Date last_access, registration_date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        // Set title
        this.setTitle("Account");

        //Inizializzo gli attributi dei campi
        init();

    }

    /**
     * Inizializzazione degli attributi corrispondenti ai componenti presenti nel layout
     */
    private void init() {
    }
}
