package com.lorenzomalferrari.holidaydiary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.lorenzomalferrari.holidaydiary.control.DatabaseHelper;

public class AddPictureActivity extends AppCompatActivity {

    EditText name, description;
    ImageView img;
    Button chooseImg, saveImg;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_picture);

        //ottengo i dati dal layout
        getDataByID();
        //inizializzo l'oggetto DatabaseHelper
        //il parametro è la classe nella quale inizializzo l'oggetto
        databaseHelper = new DatabaseHelper(this);
    }


    /**
     * Metodo che mi inizializza gli attributi
     */
    private void getDataByID(){
        name = findViewById(R.id.addImage_name);
        description = findViewById(R.id.addImage_description);
        img = findViewById(R.id.addImage_img);
        chooseImg = findViewById(R.id.addImage_choose_image);
        saveImg = findViewById(R.id.addImage_save_img);
    }
}
