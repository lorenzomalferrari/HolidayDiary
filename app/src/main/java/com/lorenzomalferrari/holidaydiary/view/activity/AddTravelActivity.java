package com.lorenzomalferrari.holidaydiary.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.lorenzomalferrari.holidaydiary.R;
import com.lorenzomalferrari.holidaydiary.control.DatabaseHelper;
import com.lorenzomalferrari.holidaydiary.model.Travel;

/**
 *
 * @author Lorenzo Malferrari - Website: www.lorenzomalferrari.com
 */
public class AddTravelActivity extends AppCompatActivity {

    EditText txttitle, txtcategory, txtdescription;
    Button addTravel;
    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_travel);
        //Cambio il titolo della Activity
        this.setTitle(getString(R.string.addTravel_title));

        databaseHelper = new DatabaseHelper(this);

        //Inizializzazione degli attributi
        init();

        addTravel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Travel travel = new Travel(txttitle.getText().toString(),txtdescription.getText().toString(),1);
                databaseHelper.insertDataTravel(travel);
                //Chiamo l'Activity che contiene la lista delle note
                callTravels();
            }
        });

    }

    private void init(){
        txttitle = findViewById(R.id.addTravel_title);
        txtcategory = findViewById(R.id.addTravel_category);
        txtdescription = findViewById(R.id.addTravel_description);
        addTravel = findViewById(R.id.addTravel_save_travel);
    }

    private void callTravels() {
        Intent intent = new Intent(this, TravelsActivity.class);
        this.startActivity(intent);
        finish();
    }

}
