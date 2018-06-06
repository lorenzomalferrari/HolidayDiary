package com.lorenzomalferrari.holidaydiary.view.activity;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.lorenzomalferrari.holidaydiary.R;
import com.lorenzomalferrari.holidaydiary.control.DatabaseHelper;
import com.lorenzomalferrari.holidaydiary.control.UserSessionManager;

/**
 *
 * @author Lorenzo Malferrari - Website: www.lorenzomalferrari.com
 */
public class AccountActivity extends AppCompatActivity {

    TextView firstName, lastName, username, email, password, city, country, gender, birthdate;
    ImageView imgUser;
    Button btnLogout;

    DatabaseHelper databaseHelper;
    // User Session Manager Class
    UserSessionManager userSessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        getSupportActionBar().setTitle(R.string.account_title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //
        databaseHelper = new DatabaseHelper(this);
        // User Session Manager
        userSessionManager = new UserSessionManager(getApplicationContext());
        //Inizializzo gli attributi dei campi
        init();

        String email = "malfe.lore@gmail.com";
        String password = "123456";
        Cursor res = databaseHelper.getDataUser(email,password);
        // Visualizzo gli attributi nei rispettivi campi
        setAccountData(res);
        //
        logout();
    }

    /**
     * Inizializzazione degli attributi corrispondenti ai componenti presenti nel layout
     */
    private void init() {
        imgUser = findViewById(R.id.account_image);
        firstName = findViewById(R.id.account_firstName_value);
        lastName = findViewById(R.id.account_lastName_value);
        username = findViewById(R.id.account_username_value);
        email = findViewById(R.id.account_email_value);
        password = findViewById(R.id.account_password_value);
        city = findViewById(R.id.account_city_value);
        country = findViewById(R.id.account_country_value);
        gender = findViewById(R.id.account_gender_value);
        birthdate = findViewById(R.id.account_birthdate_value);
        btnLogout = findViewById(R.id.btnLogout);
    }

    /**
     * Setto i campi con i dati presi dal database
     */
    private void setAccountData(Cursor res){
        //Setto immagine nella AccountActivity, immagine del profilo (Dovrebbe essere presa da DB, cosa che attualmente non è implementata)
        //imgUser.setImageResource(R.drawable.v_0578);
        //Setto i campi della AccountActivity con i dati dell'utente che è loggato
        while (res.moveToNext()){
            firstName.setText(res.getString(1));
            lastName.setText(res.getString(2));
            username.setText(res.getString(3));
            email.setText(res.getString(4));
            password.setText(res.getString(5));
            city.setText(res.getString(6));
            country.setText(res.getString(7));
            gender.setText(res.getString(8));
            birthdate.setText(res.getString(10));
        }
    }

    /**
     * Eseguo il logout del profilo
     */
    private void logout(){
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Eseguo il logout
                userSessionManager.logoutUser();
                finish();
            }
        });
    }
}
