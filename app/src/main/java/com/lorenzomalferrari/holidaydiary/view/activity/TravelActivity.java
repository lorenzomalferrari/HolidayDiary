package com.lorenzomalferrari.holidaydiary.view.activity;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.lorenzomalferrari.holidaydiary.R;

/**
 *
 * @author Lorenzo Malferrari - Website: www.lorenzomalferrari.com
 */
public class TravelActivity extends AppCompatActivity {

    //
    private TextView txttitle,txtdescription, txtcategory;
    private ImageView img;
    private CollapsingToolbarLayout collapsingToolbarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel);
        setTitle(getString(R.string.travel_title));
        // Inizializzo i componenti
        init();

        // Recieve data
        Intent intent = getIntent();
        String title = intent.getExtras().getString("TravelTitle");
        String category = intent.getExtras().getString("Category");
        String description = intent.getExtras().getString("Description");
        int image = intent.getExtras().getInt("Thumbnail");
        // Setto i componenti
        setComponents(title,category,description,image);
    }

    /**
     * Inizializzo gli attributi
     */
    private void init(){
        txttitle = findViewById(R.id.traveltitle);
        txtdescription = findViewById(R.id.descriptiontitle);
        txtcategory = findViewById(R.id.categorytitle);
        img = findViewById(R.id.travelthumbnail);
        //Inizializzo la Toolbar
        collapsingToolbarLayout = findViewById(R.id.collappsingtoolbar);
    }

    /**
     * Setto i componenti con i parametri d'ingresso
     * @param title nome del viaggio
     * @param description testo che descrive il viaggio
     * @param image immagine rappresentativa del viaggio
     */
    private void setComponents(String title,String category, String description, int image){
        // Settings values
        //txttitle.setText(title);
        txtdescription.setText(description);
        txtcategory.setText(category);
        //img.setImageResource(image);
        collapsingToolbarLayout.setBackgroundResource(image);
        collapsingToolbarLayout.setTitle(title);
    }
}
