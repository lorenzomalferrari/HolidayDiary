package com.lorenzomalferrari.holidaydiary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class NoteActivity extends AppCompatActivity {

    private TextView txttitle,txtdata,txtdescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        setTitle("Note");

        init();

        // Recieve data
        Intent intent = getIntent();
        String title = intent.getExtras().getString("Title");
        String data = intent.getExtras().getString("Data");
        String description = intent.getExtras().getString("Description");

        // Set values
        txttitle.setText(title);
        txtdata.setText(data);
        txtdescription.setText(description);
    }

    private void init() {
        txttitle = findViewById(R.id.note_title);
        txtdata = findViewById(R.id.note_data);
        txtdescription = findViewById(R.id.note_description);
    }
}
