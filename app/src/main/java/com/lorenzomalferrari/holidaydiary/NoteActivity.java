package com.lorenzomalferrari.holidaydiary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class NoteActivity extends AppCompatActivity {

    private TextView txttitle,txtdescription, txtcategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        //txttitle =
        // Recieve data
        //Intent intent = getIntent();
        //String title = intent.getExtras().getString("TravelTitle");
        //String description = intent.getExtras().getString("Description");
        //String last_mod = intent.getExtra().getString();
    }
}
