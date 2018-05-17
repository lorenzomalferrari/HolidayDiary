package com.lorenzomalferrari.holidaydiary;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lorenzomalferrari.holidaydiary.control.DatabaseHelper;
import com.lorenzomalferrari.holidaydiary.control.RecyclerViewAdapter;
import com.lorenzomalferrari.holidaydiary.control.RecyclerViewAdapterTravels;
import com.lorenzomalferrari.holidaydiary.model.Travel;

import java.util.ArrayList;
import java.util.List;

public class TravelsActivity extends AppCompatActivity {

    List<Travel> listTravel;
    DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travels);

        String sp = "Spiaggia di Zadina";
        String dueT = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce consequat porttitor ante eu semper. Cras dui lorem, finibus quis odio in, sagittis venenatis sapien. Nam ornare mattis mi, a iaculis arcu ornare ac. Ut ac imperdiet dui. Nunc vel tempor elit. Donec sit amet erat orci. Curabitur metus mauris, mollis ut varius ac, scelerisque in risus. Suspendisse nec molestie dolor. Nunc et feugiat nibh. Vestibulum eget sem quam. Donec at vulputate neque, a commodo quam. Proin id venenatis eros. Nullam dapibus commodo metus sed fringilla. Phasellus quis placerat justo, id molestie leo. Nullam nunc nisl, porta ac ornare at, congue et erat. Cras vulputate a libero eget lobortis.\n" +
                "\n" +
                "Duis vitae dignissim justo, ut gravida odio. Donec non egestas risus. Fusce eleifend felis urna, at tincidunt sem facilisis nec. Morbi a tortor in ligula iaculis auctor eget quis metus. Donec ac dui id nulla ultrices egestas sed id metus. Suspendisse potenti. Proin nec urna erat. Suspendisse nec congue erat. Curabitur vehicula rutrum libero, vitae efficitur augue suscipit auctor. Aenean id nibh ex. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Etiam molestie dui quis ex tempor, vitae dictum massa sodales. Sed turpis lacus, sagittis dignissim facilisis in, congue sed quam. Maecenas luctus efficitur felis, quis hendrerit metus vestibulum sit amet. Aliquam dignissim dui quis elit facilisis, at eleifend lacus aliquet.\n" +
                "\n" +
                "Morbi a lectus eu erat interdum placerat mattis sed lorem. Mauris ac massa vitae lorem varius congue at id turpis. Duis at velit pulvinar, ullamcorper ipsum ac, pellentesque arcu. Nullam viverra tortor tempus neque maximus, et aliquam velit auctor. Praesent luctus urna nulla, quis tincidunt nulla blandit non. Quisque a interdum nisl. Aliquam et consequat dolor, eu viverra lacus. Cras mattis a nibh non finibus. Proin et velit pulvinar, rutrum ante et, vehicula enim.\n";

        String bici_fiori = "Bici con i fiori";



        // Create list of Travel object
        listTravel = new ArrayList<>();
        databaseHelper = new DatabaseHelper(this);
        Cursor res = databaseHelper.getAll("Travels");
        // Add Travels
        while (res.moveToNext()) {
            listTravel.add(new Travel(res.getString(1),res.getString(8),res.getString(2),R.drawable.travel_1));
        }


        // Set component for to see in Activity
        RecyclerView myRecyclerView = findViewById(R.id.recyclerviewTravels_id);
        RecyclerViewAdapterTravels myRecyclerViewAdapter = new RecyclerViewAdapterTravels(this,listTravel);
        // Visualizzazione dei viaggi a 1 colonna
        myRecyclerView.setLayoutManager(new GridLayoutManager(this,1));
        myRecyclerView.setAdapter(myRecyclerViewAdapter);



    }
}
