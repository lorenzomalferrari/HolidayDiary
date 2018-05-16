package com.lorenzomalferrari.holidaydiary;
// Librerie Android
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
// Mie classi
import com.lorenzomalferrari.holidaydiary.control.DatabaseHelper;
import com.lorenzomalferrari.holidaydiary.control.RecyclerViewAdapterNotes;
import com.lorenzomalferrari.holidaydiary.model.Note;
import com.lorenzomalferrari.holidaydiary.model.Travel;
// Librerie Java
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NotesActivity extends AppCompatActivity {

    List<Note> listNote;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        // Create list of Travel object
        listNote = new ArrayList<>();
        databaseHelper = new DatabaseHelper(this);
        Cursor res = databaseHelper.getAll("Notes");
        // Add Notes
        while (res.moveToNext()) {

            listNote.add(new Note(res.getString(1),new Date(),res.getString(2)));
            /*listTravel.add(new Travel("Due Torri","Categorie Travel",dueT,R.drawable.due_torri));
            listTravel.add(new Travel("Bici con i fiori","Categorie Travel",dueT,R.drawable.bicifiori));
            listTravel.add(new Travel("Castel D'Aiano","Categorie Travel",dueT,R.drawable.bosco_1));
            listTravel.add(new Travel("Bosco","Categorie Travel",dueT,R.drawable.bosco_2));
            listTravel.add(new Travel("Piana de Rossi","Categorie Travel",dueT,R.drawable.bosco_3));*/

        }

        // Set component for to see in Activity
        RecyclerView myRecyclerView = findViewById(R.id.recyclerviewNotes_id);
        RecyclerViewAdapterNotes myRecyclerViewAdapterNotes = new RecyclerViewAdapterNotes(this,listNote);
        myRecyclerView.setLayoutManager(new GridLayoutManager(this,1));
        myRecyclerView.setAdapter(myRecyclerViewAdapterNotes);
    }
}
