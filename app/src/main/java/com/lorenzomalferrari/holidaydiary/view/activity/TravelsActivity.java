package com.lorenzomalferrari.holidaydiary.view.activity;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.lorenzomalferrari.holidaydiary.R;
import com.lorenzomalferrari.holidaydiary.control.DatabaseHelper;
import com.lorenzomalferrari.holidaydiary.control.RecyclerViewAdapter;
import com.lorenzomalferrari.holidaydiary.control.RecyclerViewAdapterTravels;
import com.lorenzomalferrari.holidaydiary.model.Travel;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lorenzo Malferrari - Website: www.lorenzomalferrari.com
 */
public class TravelsActivity extends AppCompatActivity {

    List<Travel> listTravel;
    DatabaseHelper databaseHelper;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travels);
        toolbar = findViewById(R.id.toolbar_menu);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.travels_title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Create list of Travel object
        listTravel = new ArrayList<>();
        // Setta la var dell'oggetto DatabaseHelper con il context della classe stessa
        databaseHelper = new DatabaseHelper(this);
        // Salvo tutte i Viaggi
        Cursor res = databaseHelper.getAll("Travels");
        // Add Travels
        while (res.moveToNext()) {
            //Aggiungo nella mia lista di Viaggi, un nuovo oggetto con i parametri presi dal tabella Travels presente nel database
            listTravel.add(new Travel(res.getString(1),res.getString(8),res.getString(2),R.drawable.travel_1));
        }

        // Set component for to see in Activity
        RecyclerView myRecyclerView = findViewById(R.id.recyclerviewTravels_id);
        RecyclerViewAdapterTravels myRecyclerViewAdapter = new RecyclerViewAdapterTravels(this,listTravel);
        // Visualizzazione dei viaggi a 1 colonna
        myRecyclerView.setLayoutManager(new GridLayoutManager(this,2));
        myRecyclerView.setAdapter(myRecyclerViewAdapter);
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
            case R.id.addItem:
                intent = new Intent(this, AddTravelActivity.class);
                this.startActivity(intent);
                break;
            case R.id.order_by:
                //intent = new Intent(this, TravelsActivity.class);
                //this.startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
