package com.lorenzomalferrari.holidaydiary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class TravelActivity extends AppCompatActivity {

    private TextView txttitle,txtdescription, txtcategory;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel);

        txttitle = findViewById(R.id.traveltitle);
        txtdescription = findViewById(R.id.descriptiontitle);
        txtcategory = findViewById(R.id.categorytitle);
        img = findViewById(R.id.travelthumbnail);

        // Recieve data
        Intent intent = getIntent();
        String title = intent.getExtras().getString("TravelTitle");
        String description = intent.getExtras().getString("Description");
        int image = intent.getExtras().getInt("Thumbnail");

        // Settings values
        txttitle.setText(title);
        txtdescription.setText(description);
        img.setImageResource(image);

    }
}
