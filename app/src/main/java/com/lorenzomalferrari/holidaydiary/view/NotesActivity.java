package com.lorenzomalferrari.holidaydiary.view;
// Librerie Android
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
// Mie classi
import com.lorenzomalferrari.holidaydiary.R;
import com.lorenzomalferrari.holidaydiary.control.DatabaseHelper;
import com.lorenzomalferrari.holidaydiary.control.RecyclerViewAdapterNotes;
import com.lorenzomalferrari.holidaydiary.model.Note;
// Librerie Java
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Lorenzo Malferrari - Website: www.lorenzomalferrari.com
 */
public class NotesActivity extends AppCompatActivity {

    // lista di Note
    List<Note> listNote;
    // Oggetto per collegarsi al database
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        //Set title
        this.setTitle(getString(R.string.notes_title));
        // Create list of Travel object
        listNote = new ArrayList<>();
        // Setta la var dell'oggetto DatabaseHelper con il context della classe stessa
        databaseHelper = new DatabaseHelper(this);
        // Salvo tutte le Note
        Cursor res = databaseHelper.getAll("Notes");
        // Add Notes
        while (res.moveToNext()) {
            //Aggiungo nella mia lista di Note, un nuovo oggetto con i parametri presi dal tabella Notes presente nel database
            listNote.add(new Note(res.getString(1),new Date(),res.getString(2),res.getInt(4)));
        }
        // Set component for to see in Activity
        RecyclerView myRecyclerView = findViewById(R.id.recyclerviewNotes_id);
        RecyclerViewAdapterNotes myRecyclerViewAdapterNotes = new RecyclerViewAdapterNotes(this,listNote);
        myRecyclerView.setLayoutManager(new GridLayoutManager(this,1));
        myRecyclerView.setAdapter(myRecyclerViewAdapterNotes);
    }
}
