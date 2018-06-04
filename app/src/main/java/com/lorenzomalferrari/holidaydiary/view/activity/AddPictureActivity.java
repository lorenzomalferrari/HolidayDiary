package com.lorenzomalferrari.holidaydiary.view.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.lorenzomalferrari.holidaydiary.R;
import com.lorenzomalferrari.holidaydiary.control.DatabaseHelper;
import com.lorenzomalferrari.holidaydiary.model.Picture;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 *
 * @author Lorenzo Malferrari - Website: www.lorenzomalferrari.com
 */
public class AddPictureActivity extends AppCompatActivity {

    EditText title, description;
    ImageView img;
    Button chooseImg, saveImg;
    DatabaseHelper databaseHelper;

    final int REQUEST_CODE_GALLERY = 999;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_picture);
        //Cambio il titolo della Activity
        this.setTitle(getString(R.string.addPicture_title));

        init();

        databaseHelper = new DatabaseHelper(this);

        chooseImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityCompat.requestPermissions(
                        AddPictureActivity.this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        REQUEST_CODE_GALLERY
                );
            }
        });

        //Buttone per salvare l'immagine
        saveImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    databaseHelper.inserDataImage(
                            new Picture(title.getText().toString().trim(), getImageViewByte(img), 1)
                    );
                    Toast.makeText(getApplicationContext(),"Aggiunta immagine con successo!",Toast.LENGTH_LONG).show();
                    clearComponents();
                    callPictures();
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

    }

    private void callPictures() {
        Intent intent = new Intent(this,PicturesActivity.class);
        this.startActivity(intent);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if (requestCode == REQUEST_CODE_GALLERY){
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent,REQUEST_CODE_GALLERY);
            }
            else {
                Toast.makeText(getApplicationContext(),"Tu non hai i permessi per accedere",Toast.LENGTH_LONG).show();
            }
            return;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == REQUEST_CODE_GALLERY && resultCode == RESULT_OK && data != null){
            Uri uri = data.getData();
            try {
                InputStream inputStream = null;
                if (uri != null) inputStream = getContentResolver().openInputStream(uri);
                //Setto immagine caricata
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                img.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    /**
     *
     */
    private void init(){
        title = findViewById(R.id.addImage_title);
        description = findViewById(R.id.addImage_description);
        img = findViewById(R.id.addImage_img);
        chooseImg = findViewById(R.id.addImage_choose_image);
        saveImg = findViewById(R.id.addImage_save_img);
    }

    private byte[] getImageViewByte(ImageView imageView){
        Bitmap bitmap = ((BitmapDrawable)imageView.getDrawable()).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,100,stream);
        byte[] byteArray = stream.toByteArray();
        int length = byteArray.length;
        Toast.makeText(AddPictureActivity.this,String.valueOf(length),Toast.LENGTH_LONG).show();
        //return stream.toByteArray();
        return byteArray;
    }

    private void clearComponents() {
        title.setText("");
        description.setText("");
        img.setImageResource(R.mipmap.ic_launcher_round);
    }
}
