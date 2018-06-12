package com.lorenzomalferrari.holidaydiary.view.activity;
//Import java classes
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
//Import my classes
import com.lorenzomalferrari.holidaydiary.R;
import com.lorenzomalferrari.holidaydiary.control.UserSessionManager;
import com.lorenzomalferrari.holidaydiary.control.DatabaseHelper;
import com.lorenzomalferrari.holidaydiary.control.Validator;

import br.com.simplepass.loading_button_lib.customViews.CircularProgressButton;

/**
 *
 * @author Lorenzo Malferrari - Website: www.lorenzomalferrari.com
 */
public class LoginActivity extends AppCompatActivity {

    //Bottone che clicco
    CircularProgressButton btnLogin;
    //Campi che prende
    EditText email,password;

    DatabaseHelper databaseHelper;
    LinearLayout layoutTop, layoutDown;
    Animation uptodown, downtoup;
    Validator validator;
    //User user;

    // User Session Manager Class
    UserSessionManager userSessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        this.setTitle(getString(R.string.login_title));

        // User Session Manager
        userSessionManager = new UserSessionManager(getApplicationContext());

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

        //Eseguo il login con controlli
        checkLogin();

    }

    /**
     * Metodo che mi eseguo il login
     */
    public void checkLogin() {
        btnLogin.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    /*
                        AsyncTask<String,String,String> asyncTask = new AsyncTask<String,String,String>(){

                            @Override
                            protected String doInBackground(String... strings) {
                                try {
                                    Thread.sleep(3000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                return "done";
                            }

                            @Override
                            protected void onPostExecute(String s) {
                                if (s.equals("done")){
                                    btnLogin.doneLoadingAnimation(Color.parseColor("#333639"),
                                            BitmapFactory.decodeResource(getResources(),R.drawable.ic_done_login));
                                }
                            }
                        };
                        btnLogin.startAnimation();
                        asyncTask.execute();
                    */

                        String emailLogin = email.getText().toString();
                        String passwordLogin = password.getText().toString();
                        // Start checks
                        if (validator.isFieldsEmpty(emailLogin,passwordLogin)) {
                            if (validator.isEmailValid(emailLogin)){
                                if (validator.isPasswordValid(passwordLogin)){
                                    Cursor res = databaseHelper.getDataUser(emailLogin,passwordLogin);
                                    if(res.getCount() == 0) {// se utente non esiste lo mando alla registrazione
                                        // Viasualizzo la pagina di registrazione
                                        callRegister();
                                    }
                                    else {// se utente esiste esegu il login
                                        // Creating user login session
                                        userSessionManager.createUserLoginSession(emailLogin, passwordLogin);
                                        // Creo l'oggetto User con i dati presi dal database
                                        //createUser(res);
                                        // Visualizzo l'app
                                        callMenu(emailLogin,passwordLogin);
                                    }
                                }
                                else {
                                    Toast.makeText(LoginActivity.this,"ATTENZIONE!! Password troppo corta",Toast.LENGTH_LONG).show();
                                }
                            }
                            else {
                                Toast.makeText(LoginActivity.this,"ATTENZIONE!! Email non valida",Toast.LENGTH_LONG).show();
                            }
                        }
                        else {
                            Toast.makeText(LoginActivity.this,"ATTENZIONE!! Campi sono vuoti",Toast.LENGTH_LONG).show();
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
    private void callMenu(String email, String password){
        Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
        intent.putExtra("email",email);
        intent.putExtra("password",password);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        // Add new Flag to start new Activity
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        this.startActivity(intent);
        finish();
    }

    /**
     * Chiama la RegisterActivity
     */
    private void callRegister(){
        Intent intent = new Intent(this, RegistrationActivity.class);
        this.startActivity(intent);
    }

    /*private void createUser(Cursor res){
        user = new User();
    }*/

}
