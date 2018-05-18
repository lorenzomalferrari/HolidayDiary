package com.lorenzomalferrari.holidaydiary.view;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.lorenzomalferrari.holidaydiary.R;
import com.lorenzomalferrari.holidaydiary.control.DatabaseHelper;
import com.lorenzomalferrari.holidaydiary.control.UserSessionManager;

import java.util.Date;

public class AccountActivity extends AppCompatActivity {

    TextView firstName, lastName, username, email, password, city, country, gender, birthdate;
    ImageView imgUser;

    DatabaseHelper databaseHelper;
    UserSessionManager userSessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        //
        databaseHelper = new DatabaseHelper(this);
        //check UserSessionManager
        checkUserSession();

        // Set title
        this.setTitle("Account");

        //Inizializzo gli attributi dei campi
        init();

        String email = userSessionManager.getKEY_EMAIL();
        String password = userSessionManager.getKEY_PASSWORD();
        Cursor res = databaseHelper.getDataUser(email,password);
        //
        setAccountData(res);

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
    }

    /**
     * Setto i campi con i dati presi dal database
     */
    private void setAccountData(Cursor res){
        //firstName.setText(String.valueOf(res.getCount()));
        while (res.moveToNext()){
            firstName.setText(res.getString(1).toString());
            lastName.setText(res.getString(2).toString());
            username.setText(res.getString(3).toString());
            email.setText(res.getString(4).toString());
            password.setText(res.getString(5).toString());
            city.setText(res.getString(6).toString());
            country.setText(res.getString(7).toString());
            gender.setText(res.getString(8).toString());
            birthdate.setText(res.getString(10).toString());
        }

    }

    private void checkUserSession(){
        // Session class instance
        userSessionManager = new UserSessionManager(getApplicationContext());

        /*
        Toast.makeText(
                        getApplicationContext(),
                        "User Login Status: " + userSessionManager.isUserLoggedIn(),
                        Toast.LENGTH_LONG)
                    .show();
        */
        // Check user login
        // If User is not logged in , This will redirect user to LoginActivity.
        if(userSessionManager.checkLogin()) finish();
    }
}
