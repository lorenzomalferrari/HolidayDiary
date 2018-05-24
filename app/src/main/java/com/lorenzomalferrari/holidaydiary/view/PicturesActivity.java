package com.lorenzomalferrari.holidaydiary.view;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.Toast;

import com.lorenzomalferrari.holidaydiary.R;
import com.lorenzomalferrari.holidaydiary.control.DatabaseHelper;
import com.lorenzomalferrari.holidaydiary.control.PictureListAdapter;
import com.lorenzomalferrari.holidaydiary.model.Picture;

import java.util.ArrayList;

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
        this.setTitle(getString(R.string.pictures_title));

        // Setta la var dell'oggetto DatabaseHelper con il context della classe stessa
        databaseHelper = new DatabaseHelper(this);
        gridView = findViewById(R.id.gridViewPictures_id);
        // Create list of Travel object
        listPicture = new ArrayList<Picture>();
        //listPicture = new ArrayList<>();
        pictureListAdapter = new PictureListAdapter(this, R.layout.picture_items, listPicture);
        gridView.setAdapter(pictureListAdapter);

        // Salvo tutte i Viaggi
        Cursor cursor = databaseHelper.getAll("Pictures");
        listPicture.clear();
        while (cursor.moveToNext()){
            String title = cursor.getString(1);
            Toast.makeText(getApplicationContext(),title,Toast.LENGTH_LONG).show();
            byte[] image = cursor.getBlob(3);
            int id_user = cursor.getInt(4);
            Toast.makeText(getApplicationContext(),String.valueOf(id_user),Toast.LENGTH_LONG).show();
            //Aggiungo alla lista le immagini
            listPicture.add(new Picture(title,image,id_user));
        }
        pictureListAdapter.notifyDataSetChanged();
    }
}
