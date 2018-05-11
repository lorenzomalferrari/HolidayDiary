package com.lorenzomalferrari.holidaydiary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.lorenzomalferrari.holidaydiary.model.Travel;

import java.util.ArrayList;
import java.util.List;

public class TravelsActivity extends AppCompatActivity {

    List<Travel> listTravel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travels);

        listTravel = new ArrayList<>();
        listTravel.add(new Travel("Spiaggia","Categorie Travel","Description Travel",R.drawable.travel_1));
        listTravel.add(new Travel("Spiaggia","Categorie Travel","Description Travel",R.drawable.travel_1));
        listTravel.add(new Travel("Spiaggia","Categorie Travel","Description Travel",R.drawable.travel_1));
        listTravel.add(new Travel("Spiaggia","Categorie Travel","Description Travel",R.drawable.travel_1));
        listTravel.add(new Travel("Spiaggia","Categorie Travel","Description Travel",R.drawable.travel_1));
        listTravel.add(new Travel("Spiaggia","Categorie Travel","Description Travel",R.drawable.travel_1));
        listTravel.add(new Travel("Spiaggia","Categorie Travel","Description Travel",R.drawable.travel_1));
        listTravel.add(new Travel("Spiaggia","Categorie Travel","Description Travel",R.drawable.travel_1));
        listTravel.add(new Travel("Spiaggia","Categorie Travel","Description Travel",R.drawable.travel_1));
        listTravel.add(new Travel("Spiaggia","Categorie Travel","Description Travel",R.drawable.travel_1));



    }
}
