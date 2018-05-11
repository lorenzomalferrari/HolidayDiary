package com.lorenzomalferrari.holidaydiary;
//Import java classes
import android.content.Intent;
import android.database.Cursor;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
//Import my classes
import com.lorenzomalferrari.holidaydiary.control.UserSessionManager;
import com.lorenzomalferrari.holidaydiary.model.DatabaseHelper;
import com.lorenzomalferrari.holidaydiary.model.Validator;

/**
 *
 * @author Lorenzo Malferrari - Website: www.lorenzomalferrari.com
 */
public class LoginActivity extends AppCompatActivity {

    //Bottone che clicco
    Button btnLogin;
    //Campi che prende
    EditText email,password;


    DatabaseHelper databaseHelper;
    LinearLayout layoutTop, layoutDown;
    Animation uptodown, downtoup;
    Validator validator;

    // User Session Manager Class
    //UserSessionManager userSessionManager;

    //Testo in input
    TextInputLayout emailInputLayout, passwordInputLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // User Session Manager
        //userSessionManager = new UserSessionManager(getApplicationContext());

        /* Eseguo l'animazione sulla LoginActivity */
        runAnimation();

        /* Inizializzazione dei campi per l'esecuzione del login */

        // oggetto DatabaseHelper, per la connessione del database SQLite
        databaseHelper = new DatabaseHelper(this);

        //id della email che viene inserita per il login
        email = findViewById(R.id.email);
        //id della password che viene inserita per il login
        password = findViewById(R.id.password);

        /*Toast.makeText(getApplicationContext(),
                "User Login Status: " + userSessionManager.isUserLoggedIn(),
                Toast.LENGTH_LONG).show();*/

        //id del bottone che si clicca (Login)
        btnLogin = findViewById(R.id.btnLogin);

        /* Controllo che i dati inseriti siano corretti */

        // oggetto Validator, per la validazione dei campi
        validator = new Validator();
        //if (validate(email.getText().toString(), password.getText().toString())) {
        //Sign up or login User
        checkLogin();
        //}
    }

    private boolean validate(String email, String password) {

        // Reset errors.
        emailInputLayout.setError(null);
        passwordInputLayout.setError(null);

        // Controllo l'email
        if (email.trim().length() == 0 || email == null) {
            emailInputLayout.setError("Email is required");
            return false;
        } else if (!validator.isEmailValid(email)) {
            emailInputLayout.setError("Enter a valid email");
            return false;
        }
        // Controllo la password
        if (password.trim().length() == 0 || password == null) {
            passwordInputLayout.setError("Password is required");
            return false;
        } else if (!validator.isPasswordValid(password)) {
            passwordInputLayout.setError("Password must contain at least 6 characters");
            return false;
        }
        return true;
    }

    /**
     * Metodo che mi eseguo il login
     */
    public void checkLogin() {
        btnLogin.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        /*if (email.getText().toString().trim().length() > 0 && password.getText().toString().trim().length() > 0 && validator.isEmailValid(email.getText().toString())) {
                            /* Validazione sui campi email e password */
                            /*if (isEmailValid(email.getText().toString()) && isPasswordValid(password.getText().toString())){
                                callMenu();
                            }
                            else {
                                callRegister();
                            }
                        }
                        else
                        {
                            Toast.makeText(LoginActivity.this,"ATTENZIONE!! Campi vuoti",Toast.LENGTH_LONG).show();
                        }*/


                        // Campo email e password non devono essere vuoti
                        if (email.getText().toString().trim().length() > 0 && password.getText().toString().trim().length() > 0 && validator.isEmailValid(email.getText().toString()))
                        {
                            Cursor res = databaseHelper.getData(email.getText().toString(),password.getText().toString());
                            if(res.getCount() == 0 || res == null) {// se utente non esiste lo mando alla registrazione
                                // Viasualizzo la pagina di registrazione
                                callRegister();
                            }
                            else {// se utente esiste esegu il login

                                // Creating user login session
                                // Statically storing name="Android Example"
                                // and email="androidexample84@gmail.com"
                                //userSessionManager.createUserLoginSession(email.getText().toString(), password.getText().toString());
                                // Visualizzo l'app
                                callMenu();
                            }
                        }
                        // Mandare messaggio che avverta che i campi vanno riempiti
                        else
                        {
                            Toast.makeText(LoginActivity.this,"ATTENZIONE!! Campi vuoti",Toast.LENGTH_LONG).show();
                        }

                    }
                }
        );
    }

    /**
     * Esecuzione della animazione nella LoginActivity
     */
    private void runAnimation(){
        //id del LinearLayout Top
        layoutTop = findViewById(R.id.layoutTop);
        //id del LinearLayout Down
        layoutDown = findViewById(R.id.layoutDown);
        //Animazione da top a down
        uptodown = AnimationUtils.loadAnimation(this,R.anim.uptodown);
        layoutTop.setAnimation(uptodown);
        //Animazione da down a top
        downtoup = AnimationUtils.loadAnimation(this,R.anim.downtoup);
        layoutDown.setAnimation(downtoup);
    }

    /**
     * Chiama la MenuActivity (Navigation Drawer Activity)
     */
    private void callMenu(){
        Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
        //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        // Add new Flag to start new Activity
        //intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        this.startActivity(intent);

        //finish();
    }

    /**
     * Chiama la RegisterActivity
     */
    private void callRegister(){
        Intent intent = new Intent(this, RegistrationActivity.class);
        this.startActivity(intent);
    }

}
