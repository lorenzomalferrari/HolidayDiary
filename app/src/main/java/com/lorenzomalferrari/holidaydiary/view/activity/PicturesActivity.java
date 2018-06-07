package com.lorenzomalferrari.holidaydiary.view.activity;

import android.content.Intent;
import android.database.Cursor;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.lorenzomalferrari.holidaydiary.R;
import com.lorenzomalferrari.holidaydiary.control.DatabaseHelper;
import com.lorenzomalferrari.holidaydiary.control.MasonryAdapter;
import com.lorenzomalferrari.holidaydiary.control.PictureListAdapter;
import com.lorenzomalferrari.holidaydiary.control.SpacesItemDecoration;
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
    Toolbar toolbar;
    RecyclerView mRecyclerView;

    // SpanCount between 1 and 3
    /**
     * Default number of columns is 2
     */
    private final int NUMBER_COLUMNS = 2;
    // Possible numbers are 1, 2, 3
    private final int MIN_LENGHT = 1, MAX_LENGHT = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pictures);
        toolbar = findViewById(R.id.toolbar_menu);
        //setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.pictures_title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Setta la var dell'oggetto DatabaseHelper con il context della classe stessa
        databaseHelper = new DatabaseHelper(this);
        //gridView = findViewById(R.id.gridViewPictures_id);
        // Create list of Travel object
        //listPicture = new ArrayList<>();
        //listPicture = new ArrayList<>();
        //pictureListAdapter = new PictureListAdapter(this, R.layout.picture_items, listPicture);
        //gridView.setAdapter(pictureListAdapter);

        /*// Salvo tutte i Viaggi
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
        pictureListAdapter.notifyDataSetChanged();*/

        mRecyclerView = findViewById(R.id.masonry_grid);
        //SpanCount between 1 and 3
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(NUMBER_COLUMNS, StaggeredGridLayoutManager.VERTICAL));
        MasonryAdapter adapter = new MasonryAdapter(this);
        mRecyclerView.setAdapter(adapter);
        SpacesItemDecoration decoration = new SpacesItemDecoration(16);
        mRecyclerView.addItemDecoration(decoration);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //creating intent object
        Intent intent;
        //initializing the fragment object which is selected
        switch (item.getItemId()) {
            case R.id.addItem:
                intent = new Intent(this, AddPictureActivity.class);
                this.startActivity(intent);
                break;
            case R.id.order_by:
                //intent = new Intent(this, TravelsActivity.class);
                //this.startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    /*public void click(View view){
        ImageView imageView = findViewById(R.id.picture_img_id);
        Intent intent = new Intent(this,PictureActivity.class);
        intent.putExtra("picture",imageView.get);
        ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(this,imageView,"transitionPictures");
        startActivity(intent,optionsCompat.toBundle());
    }*/
}
