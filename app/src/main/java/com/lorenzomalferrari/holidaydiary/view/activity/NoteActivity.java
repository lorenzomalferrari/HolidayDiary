package com.lorenzomalferrari.holidaydiary.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.lorenzomalferrari.holidaydiary.R;

/**
 *
 * @author Lorenzo Malferrari - Website: www.lorenzomalferrari.com
 */
public class NoteActivity extends AppCompatActivity {

    private TextView txttitle,txtdata,txtdescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        setTitle(getString(R.string.note_title));

        // Inizializzazione dei componenti del layout
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
