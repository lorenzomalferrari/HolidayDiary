package com.lorenzomalferrari.holidaydiary.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.lorenzomalferrari.holidaydiary.R;
import com.lorenzomalferrari.holidaydiary.control.DatabaseHelper;
import com.lorenzomalferrari.holidaydiary.model.Note;
import com.r0adkll.slidr.Slidr;
import com.r0adkll.slidr.model.SlidrInterface;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Lorenzo Malferrari - Website: www.lorenzomalferrari.com
 */
public class AddNoteActivity extends AppCompatActivity {

    //Attributi che rapresentano i campi nella Activity
    EditText title, description, city, country, startData, finishData;
    Button addNote;

    DatabaseHelper databaseHelper;
    private SlidrInterface slidrInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        //Cambio il titolo della Activity
        this.setTitle(getString(R.string.addNote_title));
        slidrInterface = Slidr.attach(this);

        databaseHelper = new DatabaseHelper(this);

        //Inizializzazione degli attributi
        init();

        addNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Date today = new Date();
                //SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                //String strToday = formatter.format(today);
                //Toast.makeText(AddNoteActivity.this,strToday,Toast.LENGTH_LONG).show();
                //try {
                    //today = formatter.parse(strToday);
                    //Toast.makeText(AddNoteActivity.this,today.toString(),Toast.LENGTH_LONG).show();

                //} catch (ParseException e) {
                    //e.printStackTrace();
                //}
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
        addNote = findViewById(R.id.addNote_save_note);
    }

    public void lockSlide(View view){
        slidrInterface.lock();
    }

    public void unlockSlide(View view){
        slidrInterface.unlock();
    }
}
