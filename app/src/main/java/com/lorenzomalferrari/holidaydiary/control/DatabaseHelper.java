package com.lorenzomalferrari.holidaydiary.control;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.lorenzomalferrari.holidaydiary.model.Note;
import com.lorenzomalferrari.holidaydiary.model.Picture;
import com.lorenzomalferrari.holidaydiary.model.Travel;

import java.util.ArrayList;

/**
 *
 * @author Lorenzo Malferrari - www.lorenzomalferrari.com
 */
public class DatabaseHelper extends SQLiteOpenHelper  {

    /**
     * Nome del file del database
     */
    private static final String DATABASE_NAME = "holidayDiary.db";

    /**
     * Lista delle tabelle del database
     */
    private final String[] TABLE_NAMES = new String[] {"User","Travel","Note","Picture","Places"};


    /**
     * Lista delle colonne presenti nella tabella User
     */
    private String[] COL_TABLE = new String[]{"id","firstName","lastName","username","password","email",
            "city","country","gender","age","birthdate","registration_date","last_login"};

    /**
     * Costruttore
     * @param context
     */
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    /**
     * Creazione della tabella nel database
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        //Creazione del Database
        createStructureDatabase(db);
    }

    /**
     *
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAMES[0]);
        onCreate(db);
    }

    /**
     * Inserisco i dati nel database
     *
     * (Ulteriormente da migliorare)
     * @param arrayList
     * @return
     */
    public boolean insertDataUser(ArrayList arrayList) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_TABLE[1],arrayList.get(0).toString());//nome
        contentValues.put(COL_TABLE[2],arrayList.get(1).toString());//cognome
        contentValues.put(COL_TABLE[3],arrayList.get(2).toString());//username
        contentValues.put(COL_TABLE[4],arrayList.get(3).toString());//password
        contentValues.put(COL_TABLE[5],arrayList.get(4).toString());//email
        contentValues.put(COL_TABLE[6],arrayList.get(5).toString());//città
        contentValues.put(COL_TABLE[7],arrayList.get(6).toString());//pease
        contentValues.put(COL_TABLE[8],arrayList.get(7).toString());//sesso
        //contentValues.put(COL_TABLE[9],calcAge());//con birthdate calcolare l'età
        contentValues.put(COL_TABLE[10],arrayList.get(8).toString());//data di nascita
        long result = db.insert(TABLE_NAMES[0],null ,contentValues);
        return result != -1;
    }

    public boolean inserDataImage(Picture picture){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_TABLE[10],picture.getTitle());//data di nascita
        long result = db.insert(TABLE_NAMES[2],null ,contentValues);
        return result != -1;
    }

    public boolean insertDataNote(Note note){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_TABLE[2],note.getTitle());//title
        contentValues.put(COL_TABLE[3],note.getContent());//content
        contentValues.put(COL_TABLE[4],note.getCreation_date().toString());//creation_date
        //contentValues.put(COL_TABLE[5],note.getId_user());//id_user
        //contentValues.put(COL_TABLE[6],note.getId_travel());//id_travel
        //contentValues.put(COL_TABLE[7],note.getId_place());//id_place
        //contentValues.put(COL_TABLE[8],note.getId_picture());//id_picture
        long result = db.insert(TABLE_NAMES[2],null ,contentValues);
        return result != -1;
    }

    public boolean insertDataTravel(Travel travel){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_TABLE[1],travel.getTitle());//Inserisco il titolo
        long result = db.insert(TABLE_NAMES[1],null ,contentValues);
        return result != -1;

    }

    /**
     * Ottengo tutti i dati degli utenti presenti nella tabella
     * @return
     */
    public Cursor getAllUsers() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM "+TABLE_NAMES[0],null);
        return res;
    }


    /**
     * Costruzione del database holidayDiary
     * @param db
     */
    private void createStructureDatabase(SQLiteDatabase db){
        //Creazione della tabella User
        crateUsersTable(db);
        //Creazione della tabella Travel
        //createTravelsTable(db);
        //Creazione della tabella Note
        //createNotesTable(db);
        //Creazione della tabella Picture
        createPicturesTable(db);
        //Creazione della tabella Position
        //createPlacesTable(db);


    }

    /**
     * Costruzione della tabella Users
     * @param db
     */
    private void crateUsersTable(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS "+ TABLE_NAMES[0] + " (" +
                "id INTEGER PRIMARY KEY," +
                "firstName VARCHAR(255)," +
                "lastName VARCHAR(255)," +
                "username VARCHAR(255)," +
                "password VARCHAR(255)," +
                "email VARCHAR(255)," +
                "city VARCHAR(255)," +
                "country VARCHAR(255)," +
                "gender CHAR(1)," +
                "age VARCHAR(255)," +
                "birthdate DATE," +
                "registration_date DATETIME," +
                "last_login DATETIME);");
    }

    /**
     * Costruzione della tabella Travels
     * @param db
     */
    private void createTravelsTable(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS "+ TABLE_NAMES[1] + "(" +
                "id INTEGER PRIMARY KEY," +
                "title VARCHAR(255)," +
                "category VARCHAR(255)," +
                "description VARCHAR(255)," +
                "registration_date DATETIME");
    }

    /**
     * Costruzione della tabella Notes
     * @param db
     */
    private void createNotesTable(SQLiteDatabase db){

    }

    /**
     * Costruzione della tabella Pitures
     * @param db
     */
    private void createPicturesTable(SQLiteDatabase db){
        db.execSQL("CREATE TABLE IF NOT EXISTS "+ TABLE_NAMES[3] + " (" +
                "id integer PRImary key," +
                "title text not null," +
                "description text," +
                "path text not null," +
                "id_user text not null," +
                "id_travel integer," +
                "id_place integer," +
                "id_note integer," +
                "foreign key (id_user) references User (id)," +
                "foreign key (id_travel) references Travel (id)," +
                "foreign key (id_place) references Place (id)," +
                "foreign key (id_note) references Note (id));");
    }

    /**
     * Costruzione della tabella Places
     * @param db
     */
    private void createPlacesTable(SQLiteDatabase db){

    }

    /**
     * Ottengo tutti i dati di un utente preciso con i seguenti parametri
     * @param email
     * @param password
     * @return
     */
    public Cursor getDataUser(String email,String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM "+TABLE_NAMES[0] + " WHERE email = '"+email+"' AND password = '"+password+"'",null);
        return res;
    }

    /**
     * Non ancora implementato del tutto
     * @param id
     * @param firstName
     * @param lastName
     * @param username
     * @return
     */
    public boolean updateData(String id,String firstName,String lastName,String username) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_TABLE[0],id);
        contentValues.put(COL_TABLE[1],firstName);
        contentValues.put(COL_TABLE[2],lastName);
        contentValues.put(COL_TABLE[3],username);
        db.update(TABLE_NAMES[0], contentValues, "ID = ?",new String[] { id });
        return true;
    }

    /**
     * Elimino utente dalla tabella
     * @param id
     * @return
     */
    public Integer deleteData (String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAMES[0], "ID = ?",new String[] {id});
    }

}
