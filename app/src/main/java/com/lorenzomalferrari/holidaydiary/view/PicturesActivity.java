package com.lorenzomalferrari.holidaydiary.view;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.Toast;

import com.lorenzomalferrari.holidaydiary.R;
import com.lorenzomalferrari.holidaydiary.control.DatabaseHelper;
import com.lorenzomalferrari.holidaydiary.control.PictureListAdapter;
import com.lorenzomalferrari.holidaydiary.model.Picture;
import com.lorenzomalferrari.holidaydiary.model.Travel;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lorenzo Malferrari - Website: www.lorenzomalferrari.com
 */
public class PicturesActivity extends AppCompatActivity {

    GridView gridView;
    ArrayList<Picture> listPicture;
    PictureListAdapter pictureListAdapter;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pictures);
        //Set title with @string
        this.setTitle("Pictures");

        // Create list of Travel object
        listPicture = new ArrayList<Picture>();
        // Setta la var dell'oggetto DatabaseHelper con il context della classe stessa
        databaseHelper = new DatabaseHelper(this);

        //Toast.makeText(getApplicationContext(),String.valueOf(res.getCount()),Toast.LENGTH_LONG).show();

        gridView = findViewById(R.id.gridViewPictures_id);
        //listPicture = new ArrayList<>();
        pictureListAdapter = new PictureListAdapter(this, R.layout.picture_items, listPicture);
        gridView.setAdapter(pictureListAdapter);

        // Salvo tutte i Viaggi
        Cursor res = databaseHelper.getAll("Pictures");
        listPicture.clear();
        // Add Travels
        while (res.moveToNext()) {

            byte [] image = res.getBlob(3);
            //Aggiungo nella mia lista di Viaggi, un nuovo oggetto con i parametri presi dal tabella Travels presente nel database
            listPicture.add(new Picture(res.getString(0), image ,1));
        }

        pictureListAdapter.notifyDataSetChanged();


    }
}
