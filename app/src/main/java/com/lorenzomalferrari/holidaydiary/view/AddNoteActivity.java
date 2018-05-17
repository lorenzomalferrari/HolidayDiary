package com.lorenzomalferrari.holidaydiary.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.lorenzomalferrari.holidaydiary.R;
import com.lorenzomalferrari.holidaydiary.control.DatabaseHelper;
import com.lorenzomalferrari.holidaydiary.model.Note;

import java.util.Date;

public class AddNoteActivity extends AppCompatActivity {

    //Attributi che rapresentano i campi nella Activity
    EditText title, description, city, country, startData, finishData;
    ImageView image;
    Button chooseImage, addNote;

    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        //Cambio il titolo della Activity
        this.setTitle("Add Note");

        databaseHelper = new DatabaseHelper(this);

        //Inizializzazione degli attributi
        init();

        addNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Note note = new Note(title.getText().toString(),new Date(),description.getText().toString(),1);
                databaseHelper.insertDataNote(note);
                //Chiamo l'Activity che contiene la lista delle note
                callNotes();
            }
        });
    }

    private void callNotes() {
        Intent intent = new Intent(this, NotesActivity.class);
        this.startActivity(intent);
        finish();
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
        addNote = findViewById(R.id.addNote_save_note);
    }
}
