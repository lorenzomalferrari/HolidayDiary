package com.lorenzomalferrari.holidaydiary.view;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.lorenzomalferrari.holidaydiary.R;

public class TravelActivity extends AppCompatActivity {


    private TextView txttitle,txtdescription, txtcategory;
    private ImageView img;
    private CollapsingToolbarLayout collapsingToolbarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel);
        setTitle("Travel");

        init();

        // Recieve data
        Intent intent = getIntent();
        String title = intent.getExtras().getString("TravelTitle");
        String description = intent.getExtras().getString("Description");
        int image = intent.getExtras().getInt("Thumbnail");

        setComponents(title,description,image);

    }

    private void init(){
        txttitle = findViewById(R.id.traveltitle);
        txtdescription = findViewById(R.id.descriptiontitle);
        txtcategory = findViewById(R.id.categorytitle);
        img = findViewById(R.id.travelthumbnail);

        //Inizializzo la Toolbar
        collapsingToolbarLayout = findViewById(R.id.collappsingtoolbar);
    }

    private void setComponents(String title, String description, int image){
        // Settings values
        //txttitle.setText(title);
        txtdescription.setText(description);
        //img.setImageResource(image);*/
        collapsingToolbarLayout.setBackgroundResource(image);
        collapsingToolbarLayout.setTitle(title);

    }
}
