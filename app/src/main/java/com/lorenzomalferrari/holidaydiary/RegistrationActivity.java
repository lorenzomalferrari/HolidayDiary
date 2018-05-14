package com.lorenzomalferrari.holidaydiary;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.lorenzomalferrari.holidaydiary.model.DatabaseHelper;
import com.lorenzomalferrari.holidaydiary.model.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class RegistrationActivity extends AppCompatActivity {

    DatabaseHelper databaseHelper;
    Button btnAddData,btnviewAll,btnDelete;
    //
    RadioButton gender;
    //
    EditText id,firstName,lastName,username,password,conf_password,email,city,country,birthdate;
    //
    Button btnviewUpdate;

    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        databaseHelper = new DatabaseHelper(this);

        //Ottengo i dati
        this.getData();
        //Creo oggetto user
        //createUser();

        btnAddData = findViewById(R.id.btnSave);
        btnviewAll = findViewById(R.id.button_viewAll);
        btnviewUpdate= findViewById(R.id.button_update);
        btnDelete= findViewById(R.id.button_delete);

        //Uso escusivo in sviluppo per fare pulidia degli utenti
        id = findViewById(R.id.register_firstNameValue);
        //
        AddData();
        viewAll();
        //UpdateData();
        DeleteData();
    }

    /**
     * Metodo che mi consente di raggruppare tutti i valori presi dalla registrazione
     * @return un oggetto di classe ArrayList
     */
    private ArrayList createArrayList(){
        ArrayList arrayList = new ArrayList();
        arrayList.add(firstName.getText().toString());
        arrayList.add(lastName.getText().toString());
        arrayList.add(username.getText().toString());
        arrayList.add(password.getText().toString());
        arrayList.add(email.getText().toString());
        arrayList.add(city.getText().toString());
        arrayList.add(country.getText().toString());
        arrayList.add(gender.getText().toString());
        arrayList.add(birthdate.getText().toString());
        return arrayList;
    }


    /**
     * Metodo per ottenere il radioButton selezionato
     * @return
     */
    private RadioButton getRadioButtonChecked(){
        RadioButton radioMale =  findViewById(R.id.radioButtonMale);
        RadioButton radioFemale =  findViewById(R.id.radioButtonFemale);
        if (radioMale.isChecked() == true){
            return radioMale;
        }
        else
            return radioFemale;
    }

    /**
     * Cancello l' Utente sapendo il suo id
     */
    public void DeleteData() {
        btnDelete.setOnClickListener(
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
        );
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
                        boolean isInserted = databaseHelper.insertData(createArrayList());
                        if(isInserted == true) {
                            Toast.makeText(RegistrationActivity.this,"Data Inserted",Toast.LENGTH_LONG).show();
                            callMenu();
                        }
                        else
                            Toast.makeText(RegistrationActivity.this,"Data not Inserted",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    /**
     * Visualizzo tutti i dati di tutti gli Utenti presenti nel database
     */
    public void viewAll() {
        btnviewAll.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = databaseHelper.getAllUsers();
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
                            buffer.append("Password: "+ res.getString(4)+"\n");
                            buffer.append("Email: "+ res.getString(5)+"\n");
                            buffer.append("City: "+ res.getString(6)+"\n");
                            buffer.append("Country: "+ res.getString(7)+"\n");
                            buffer.append("Gender: "+ res.getString(8)+"\n");
                            buffer.append("Birthdate: "+ res.getString(10)+"\n\n");
                        }

                        // Show all data
                        showMessage("Data",buffer.toString());
                    }
                }
        );
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
     */
    private void callMenu(){
        Intent intent = new Intent(this, MenuActivity.class);
        this.startActivity(intent);
        finish();
    }

    /**
     * Creo l'oggetto User
     */
    private void createUser() {
        // Creo un oggetto per creare le date tramite stringhe
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        //Costruisco oggetto utente
        char gender = this.gender.getText().charAt(0);
        String format_birthdate = this.birthdate.getText().toString().replace("/","-");
        //Test
        //Toast.makeText(RegistrationActivity.this,birthdate,Toast.LENGTH_LONG).show();

        try {
            user = new User(firstName.getText().toString().replace(" ",""),
                            lastName.getText().toString().replace(" ",""),
                            username.getText().toString().replace(" ",""),
                            email.getText().toString().replace(" ",""),
                            password.getText().toString().replace(" ",""),
                            city.getText().toString().replace(" ",""),
                            country.getText().toString().replace(" ",""),
                            gender,
                            simpleDateFormat.parse(format_birthdate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * Ottengo i dati inseriti dall'utente
     */
    private void getData(){
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
        gender = getRadioButtonChecked();
        // Birthdate
        birthdate =  findViewById(R.id.register_birthdateValue);
    }
}
