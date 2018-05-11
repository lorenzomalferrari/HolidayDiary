package com.lorenzomalferrari.holidaydiary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lorenzomalferrari.holidaydiary.model.RecyclerViewAdapter;
import com.lorenzomalferrari.holidaydiary.model.Travel;

import java.util.ArrayList;
import java.util.List;

public class TravelsActivity extends AppCompatActivity {

    List<Travel> listTravel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travels);

        String sp = "Spiaggia di Zadina";
        String dueT = "Immagine delle due torri";

        listTravel = new ArrayList<>();
        listTravel.add(new Travel("Spiaggia","Categorie Travel",sp,R.drawable.travel_1));
        listTravel.add(new Travel("Due Torri","Categorie Travel",dueT,R.drawable.due_torri));
        listTravel.add(new Travel("Spiaggia","Categorie Travel",sp,R.drawable.travel_1));
        listTravel.add(new Travel("Due Torri","Categorie Travel",dueT,R.drawable.due_torri));
        listTravel.add(new Travel("Spiaggia","Categorie Travel",sp,R.drawable.travel_1));
        listTravel.add(new Travel("Due Torri","Categorie Travel",dueT,R.drawable.due_torri));
        listTravel.add(new Travel("Spiaggia","Categorie Travel",sp,R.drawable.travel_1));
        listTravel.add(new Travel("Due Torri","Categorie Travel",dueT,R.drawable.due_torri));
        listTravel.add(new Travel("Spiaggia","Categorie Travel",sp,R.drawable.travel_1));
        listTravel.add(new Travel("Due Torri","Categorie Travel",dueT,R.drawable.due_torri));
        listTravel.add(new Travel("Spiaggia","Categorie Travel",sp,R.drawable.travel_1));
        listTravel.add(new Travel("Due Torri","Categorie Travel",dueT,R.drawable.due_torri));
        listTravel.add(new Travel("Spiaggia","Categorie Travel",sp,R.drawable.travel_1));
        listTravel.add(new Travel("Due Torri","Categorie Travel",dueT,R.drawable.due_torri));
        listTravel.add(new Travel("Spiaggia","Categorie Travel",sp,R.drawable.travel_1));
        listTravel.add(new Travel("Due Torri","Categorie Travel",dueT,R.drawable.due_torri));
        listTravel.add(new Travel("Spiaggia","Categorie Travel",sp,R.drawable.travel_1));
        listTravel.add(new Travel("Due Torri","Categorie Travel",dueT,R.drawable.due_torri));
        listTravel.add(new Travel("Spiaggia","Categorie Travel",sp,R.drawable.travel_1));
        listTravel.add(new Travel("Due Torri","Categorie Travel",dueT,R.drawable.due_torri));
        listTravel.add(new Travel("Spiaggia","Categorie Travel",sp,R.drawable.travel_1));
        listTravel.add(new Travel("Due Torri","Categorie Travel",dueT,R.drawable.due_torri));




        RecyclerView myRecyclerView = findViewById(R.id.recyclerview_id);
        RecyclerViewAdapter myRecyclerViewAdapter = new RecyclerViewAdapter(this,listTravel);
        myRecyclerView.setLayoutManager(new GridLayoutManager(this,3));
        myRecyclerView.setAdapter(myRecyclerViewAdapter);



    }
}
