package com.lorenzomalferrari.holidaydiary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class AddNoteActivity extends AppCompatActivity {

    //Attributi che rapresentano i campi nella Activity
    EditText title, description, city, country, startData, finishData;
    ImageView image;
    Button chooseImage, addTravel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        //Cambio il titolo della Activity
        this.setTitle("Add Note");

        //Inizializzazione degli attributi
        init();
    }

    /**
     * Inizializzo gli attributi con i dati ricevuti dal layout
     */
    private void init(){
        title = findViewById(R.id.addNote_title);
        description = findViewById(R.id.addNote_description);
        city = findViewById(R.id.addNote_city);
        country = findViewById(R.id.addNote_country);
        startData = findViewById(R.id.addNote_start_data);
        finishData = findViewById(R.id.addNote_finish_data);
        //image = findViewById(R.id.addNote_img);
        //chooseImage = findViewById(R.id.addNote_choose_image);
        addTravel = findViewById(R.id.addNote_save_note);
    }
}
