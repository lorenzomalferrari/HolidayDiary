package com.lorenzomalferrari.holidaydiary;
//Import java classes
import android.content.Intent;
import android.database.Cursor;
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
import com.lorenzomalferrari.holidaydiary.control.DatabaseHelper;
import com.lorenzomalferrari.holidaydiary.model.User;
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
    User user;

    // User Session Manager Class
    UserSessionManager userSessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

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

                        String emailLogin = email.getText().toString();
                        String passwordLogin = password.getText().toString();
                        // Start checks
                        if (validator.isFieldsEmpty(emailLogin,passwordLogin)){
                            if (validator.isEmailValid(email.getText().toString())){
                                if (validator.isPasswordValid(password.getText().toString())){
                                    Cursor res = databaseHelper.getData(email.getText().toString(),password.getText().toString());
                                    if(res.getCount() == 0 || res == null) {// se utente non esiste lo mando alla registrazione
                                        // Viasualizzo la pagina di registrazione
                                        callRegister();
                                    }
                                    else {// se utente esiste esegu il login
                                        // Creating user login session
                                        userSessionManager.createUserLoginSession(email.getText().toString(), password.getText().toString());
                                        // Creo l'oggetto User con i dati presi dal database
                                        // createUser(res);
                                        // Visualizzo l'app
                                        callMenu();
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
    private void callMenu(){
        Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
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
        finish();
    }

    /*private void createUser(Cursor res){
        user = new User(Integer.parseInt(res.getString(0).toString()),
                res.getString(1),
                res.getString(2),
                res.getString(3),
                res.getString(4),
                res.getString(5),
                res.getString(6),
                res.getString(7),
                res.getString(8),
                res.getString(9),
                res.getString(10));
    }*/

}
