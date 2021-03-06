package com.lorenzomalferrari.holidaydiary.view.activity;
// Librerie Android
import android.content.Intent;
import android.database.Cursor;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
// Mie classi
import com.github.clans.fab.FloatingActionButton;
import com.jude.swipbackhelper.SwipeBackHelper;
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
    Toolbar toolbar;
    //private SlidrInterface slidrInterface;
    FloatingActionButton floatingActionButton;
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SwipeBackHelper.onCreate(this);
        setContentView(R.layout.activity_notes);
        toolbar = findViewById(R.id.toolbar_menu);
        //setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.notes_title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        intent = getIntent();
        int id_user = intent.getIntExtra("id_user",0);

        //toolbar.setNavigationIcon(R.drawable.ic_action_back);
        floatingActionButton = findViewById(R.id.addTravel);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NotesActivity.this,AddNoteActivity.class));
            }
        });

        //slidrInterface = Slidr.attach(this);

        // Create list of Travel object
        listNote = new ArrayList<>();
        // Setta la var dell'oggetto DatabaseHelper con il context della classe stessa
        databaseHelper = new DatabaseHelper(this);
        // Salvo tutte le Note
        Cursor res = databaseHelper.getAll("Notes",id_user);

        Date data = new Date();
        //SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy"); // creo l'oggetto
        //String a = simpleDateFormat.format(data);
        //DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.ITALY);
        // Add Notes
        while (res.moveToNext()) {
            String stringData = res.getString(3);
            //Toast.makeText(NotesActivity.this,stringData,Toast.LENGTH_LONG).show();

            /*try {
                simpleDateFormat.format(data);
                data = simpleDateFormat.parse(stringData);

            } catch (ParseException e) {
                e.printStackTrace();
            }*/
            //Aggiungo nella mia lista di Note, un nuovo oggetto con i parametri presi dal tabella Notes presente nel database
            listNote.add(new Note(res.getString(1),/*dateFormat.format(data)*/data,res.getString(2),res.getInt(4)));
        }
        // Set component for to see in Activity
        RecyclerView myRecyclerView = findViewById(R.id.recyclerviewNotes_id);
        RecyclerViewAdapterNotes myRecyclerViewAdapterNotes = new RecyclerViewAdapterNotes(this,listNote);
        myRecyclerView.setLayoutManager(new GridLayoutManager(this,1));
        myRecyclerView.setAdapter(myRecyclerViewAdapterNotes);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //creating intent object
        Intent intent;
        //initializing the fragment object which is selected
        switch (item.getItemId()) {
            /*case R.id.addItem:
                intent = new Intent(this, AddNoteActivity.class);
                this.startActivity(intent);
                break;*/
            case R.id.order_by:
                //intent = new Intent(this, TravelsActivity.class);
                //this.startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);
        SwipeBackHelper.onPostCreate(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SwipeBackHelper.onDestroy(this);
    }

    public void lockSlide(View view){
        //slidrInterface.lock();
    }

    public void unlockSlide(View view){
        //slidrInterface.unlock();
    }
}
