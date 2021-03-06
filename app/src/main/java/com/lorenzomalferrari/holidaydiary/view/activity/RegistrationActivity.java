package com.lorenzomalferrari.holidaydiary.view.activity;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.lorenzomalferrari.holidaydiary.R;
import com.lorenzomalferrari.holidaydiary.control.DatabaseHelper;
import com.lorenzomalferrari.holidaydiary.control.UserSessionManager;
import com.lorenzomalferrari.holidaydiary.model.User;
import com.lorenzomalferrari.holidaydiary.control.Validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author Lorenzo Malferrari - Website: www.lorenzomalferrari.com
 */
public class RegistrationActivity extends AppCompatActivity {

    //
    Button btnAddData,btnviewAll,btnDelete,btnviewUpdate;
    RadioButton male, female;
    EditText id,firstName,lastName,username,password,conf_password,email,city,country,birthdate;
    String genderSelected = "";
    // User Object
    User user;
    // Validator Object
    Validator validator = new Validator();
    // User Session Manager Object
    UserSessionManager userSessionManager;
    // DatabaseHelper Object
    DatabaseHelper databaseHelper;
    // Toolbar Object
    Toolbar toolbar;

    // Create object of SharedPreferences.
    //SharedPreferences sharedPref;
    //Now get Editor
    //SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        toolbar = findViewById(R.id.toolbar_menu);
        //setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.registration_title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // DatabaseHelper Object
        databaseHelper = new DatabaseHelper(this);
        // User Session Manager Object
        userSessionManager = new UserSessionManager(getApplicationContext());
        // Inizializzo i componenti
        this.init();

        //Uso escusivo in sviluppo per fare pulidia degli utenti
        //id = findViewById(R.id.register_firstNameValue);

        AddData();
        //viewAllUsers();
        //UpdateData();
        //DeleteData();
    }

    /**
     * Cancello l' Utente sapendo il suo id
     */
    public void DeleteData() {
        /*btnDelete.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Integer deletedRows = databaseHelper.deleteData(id.getText().toString());
                        if(deletedRows > 0)
                            Toast.makeText(RegistrationActivity.this,"Data Deleted",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(RegistrationActivity.this,"Data not Deleted",Toast.LENGTH_LONG).show();
                    }
                }
        );*/
    }

    /**
     * Aggiorna campi dell' Utente
     * id, firstName, lastName, password
     */
    public void UpdateData() {
        btnviewUpdate.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isUpdate = databaseHelper.updateData(id.getText().toString(),
                                firstName.getText().toString(),
                                lastName.getText().toString(),password.getText().toString());
                        if(isUpdate == true)
                            Toast.makeText(RegistrationActivity.this,"Data Update",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(RegistrationActivity.this,"Data not Updated",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    /**
     * Aggiunge Utente nel database
     */
    public  void AddData() {
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        /*
                            1 Controllo la validità dei campi;
                                - Nome e Cognome solo testo;
                                - Username come ti pare;
                                - Email deve rispettare la sintassi email;
                                - Password = Conf Password;
                                - City e Country attualmente niente;
                                - Gender valore cliccato;
                                - Compleanno usare widget appropriato, attualmente testo custom
                            2 Controllo che l'email non sia già presente del db;
                                - Verificare che non esistano diversi profili con la stessa email
                            3 Eseguo inserimento dei dati Utente nel db
                            4 Creo l'oggetto UserSessionManager per tenermi i dati di login
                            5 Chiamo il menu, passandogli anche i dati di log
                        */

                        //ottengo il radioButton cliccato da User
                        getRadioButtonChecked();
                        //controllo che tutti i campi rispecchino le richieste progettuali
                        if (checkData()){ //campi tutti validi procedo
                            //Creo utente e lo carico sul database
                            boolean isUserInserted = databaseHelper.insertDataUser(createUser());
                            if (isUserInserted) {
                                Toast.makeText(RegistrationActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
                                userSessionManager.createUserLoginSession(email.getText().toString(), password.getText().toString());
                                //Chiamo il menù dell'app (il vero contenuto dell'app)
                                callMenu(email.getText().toString(), password.getText().toString());
                            }
                            else Toast.makeText(RegistrationActivity.this, "Data not Inserted", Toast.LENGTH_LONG).show();
                        }
                        else {
                            //Mando messagio preciso, per far capire all'utente cosa è sbagliato
                        }
                    }
                }
        );
    }

    /**
     * Visualizzo tutti i dati di tutti gli Utenti presenti nel database
     */
    public void viewAllUsers() {
        /*btnviewAll.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = databaseHelper.getAll("Users");
                        if(res.getCount() == 0) {
                            // show message
                            showMessage("Error","Nothing found");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            buffer.append("Id: "+ res.getString(0)+"\n");
                            buffer.append("Nome: "+ res.getString(1)+"\n");
                            buffer.append("Cognome: "+ res.getString(2)+"\n");
                            buffer.append("Username: "+ res.getString(3)+"\n");
                            buffer.append("Email: "+ res.getString(4)+"\n");
                            buffer.append("Password: "+ res.getString(5)+"\n");
                            buffer.append("City: "+ res.getString(6)+"\n");
                            buffer.append("Country: "+ res.getString(7)+"\n");
                            buffer.append("Gender: "+ res.getString(8)+"\n");
                            buffer.append("Birthdate: "+ res.getString(9)+"\n\n");
                            buffer.append("Age: "+ res.getInt(10)+"\n\n");
                            buffer.append("ImgProfilo: "+ res.getInt(11)+"\n\n");
                            buffer.append("Last_access: "+ res.getString(12)+"\n\n");
                            buffer.append("Registration_data: "+ res.getString(13)+"\n\n");
                        }

                        // Show all data
                        showMessage("Data",buffer.toString());
                    }
                }
        );*/
    }

    /**
     * Mostro un messagio a seconda dei dati che ricevo
     * @param title
     * @param Message
     */
    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);//funziona solo con Activity
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

    /**
     * Chiamata alla MenuActivity (Navigation Drawer Activity)
     * @param email email che l'utente ha inserito al momemnto della registrazione
     * @param password password che l'utente ha inserito al momemnto della registrazione
     */
    private void callMenu(String email, String password){
        Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
        intent.putExtra("email",email);
        intent.putExtra("password",password);
        this.startActivity(intent);
        finish();
    }

    /**
     * Creo l'oggetto User
     */
    private User createUser() {
        //convertire birthdate da String a Date
        SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yy");
        try {
            Date date = DATE_FORMAT.parse(birthdate.getText().toString());
            int img = 1;
            this.user = new User(
                    firstName.getText().toString(),
                    lastName.getText().toString(),
                    username.getText().toString(),
                    email.getText().toString(),
                    password.getText().toString(),
                    city.getText().toString(),
                    country.getText().toString(),
                    genderSelected,
                    date, // birthdate
                    validator.calcAge(date), // age
                    img, // picture id
                    new Date(), // last_access
                    new Date() // registration_date
            );
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return user;
    }

    /**
     * Ottengo i dati inseriti dall'utente
     */
    private void init(){
        // FirstName
        firstName = findViewById(R.id.register_firstNameValue);
        // LastName
        lastName = findViewById(R.id.register_lastNameValue);
        // Username
        username =  findViewById(R.id.register_usarnameValue);
        // Email
        email =  findViewById(R.id.register_emailValue);
        // Password
        password =  findViewById(R.id.register_passwordValue);
        // Confirm Password
        conf_password =  findViewById(R.id.register_passwordValueValidate);
        // City
        city =  findViewById(R.id.register_cityValue);
        // Country
        country =  findViewById(R.id.register_countryValue);
        // Gender
        male = findViewById(R.id.radioButtonMale);
        female = findViewById(R.id.radioButtonFemale);
        // Birthdate
        birthdate =  findViewById(R.id.register_birthdateValue);
        // Add User
        btnAddData = findViewById(R.id.btnSave);
        // View All Users
        btnviewAll = findViewById(R.id.button_viewAll);
        // Update User
        btnviewUpdate= findViewById(R.id.button_update);
        // Delete User
        btnDelete= findViewById(R.id.button_delete);

    }

    /**
     * Controllo che i dati inseriti dall'utente sino corretti
     * @return true - Tutto ok, false - Campi non rispettano parametri
     */
    private boolean checkData() {
        boolean flag;
        //Controllo che i obbligatori non siano vuoti
        flag = validator.isNameValid(firstName.getText().toString(), lastName.getText().toString()) &&
                validator.isEmailValid(email.getText().toString()) &&
                validator.isPasswordValid(password.getText().toString()) &&
                validator.isFieldsEmpty(email.getText().toString(), password.getText().toString());
        return flag;
    }

    /**
     * Controllo che password sia uguale a conf_password
     * @return true se le password corrispondono, false se non corrispondono
     */
    private boolean equalsPassword(){
        if (password.getText().toString().equals(conf_password.getText().toString())){
            Toast.makeText(RegistrationActivity.this,String.valueOf(true), Toast.LENGTH_LONG).show();
            return true;
        }
        else return false;
    }

    /**
     * Metodo per ottenere il radioButton selezionato
     * @return Maschio o Femmina a seconda di cosa è stato cliccato
     */
    private void getRadioButtonChecked(){
        if (male.isChecked()) genderSelected = male.getText().toString();
        else genderSelected = female.getText().toString();
    }
}
