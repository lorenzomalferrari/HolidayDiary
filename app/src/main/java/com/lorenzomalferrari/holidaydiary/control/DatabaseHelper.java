package com.lorenzomalferrari.holidaydiary.control;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.lorenzomalferrari.holidaydiary.model.Note;
import com.lorenzomalferrari.holidaydiary.model.Picture;
import com.lorenzomalferrari.holidaydiary.model.Travel;
import com.lorenzomalferrari.holidaydiary.model.User;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Lorenzo Malferrari - www.lorenzomalferrari.com
 */
public class DatabaseHelper extends SQLiteOpenHelper  {

    /**
     * Nome del file del database
     */
    private static final String DATABASE_NAME = "HolidayDiary.db";

    /**
     * Lista delle tabelle del database
     */
    private final String[] TABLE_NAMES = new String[] {"Users","Travels","Notes","Pictures","Places"};

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
        //Aggiunta di dati nel databse
        addDataDatabase(db);
    }

    /**
     * Aggiunta di dati nelle tabelle
     * (Così alla chiamata delle Activity saranno visualizzati i dati presenti nel db)
     * @param db
     */
    private void addDataDatabase(SQLiteDatabase db) {

        //Aggiungo Notes
        db.execSQL("INSERT INTO 'Notes' ('title', 'description' , 'id_user' )\n" +
                "VALUES (\"Fare la spesa\", \"Questa è la nota numero 1\",1);\n");
        db.execSQL("INSERT INTO 'Notes' ('title', 'description' , 'id_user' )\n" +
                "VALUES (\"Andare dal dentista\", \"Questa è la nota numero 2\",1);\n");
        db.execSQL("INSERT INTO 'Notes' ('title', 'description' , 'id_user' )\n" +
                "VALUES (\"Appuntamento cena\", \"Questa è la nota numero 3\",1);\n");
        db.execSQL("INSERT INTO 'Notes' ('title', 'description' , 'id_user' )\n" +
                "VALUES (\"Prendere fiori\", \"Questa è la nota numero 4\",1);\n");
        db.execSQL("INSERT INTO 'Notes' ('title', 'description' , 'id_user' )\n" +
                "VALUES (\"Benzina\", \"Ricordarsi di fare benzina\",1);\n");
        db.execSQL("INSERT INTO 'Notes' ('title', 'description' , 'id_user' )\n" +
                "VALUES (\"Notaio\", \"Mercoledì pomeriggio andare dal notaio\",1);\n");
        db.execSQL("INSERT INTO 'Notes' ('title', 'description' , 'id_user' )\n" +
                "VALUES (\"Nuoto\", \"Andare a iscriversi a nuoto\",1);\n");
        db.execSQL("INSERT INTO 'Notes' ('title', 'description' , 'id_user' )\n" +
                "VALUES (\"Palestra\", \"Disdire la palestra\",1);\n");

        //Aggiungo Travels
        db.execSQL("INSERT INTO 'Travels' ('title', 'description' , 'id_user' )\n" +
                "VALUES (\"Monaco\", \"Bellissima città e tanta birra\" ,1);");
        db.execSQL("INSERT INTO 'Travels' ('title', 'description' , 'id_user' )\n" +
                "VALUES (\"Parigi\", \"Bellissimi monumenti\" ,1);");
        db.execSQL("INSERT INTO 'Travels' ('title', 'description' , 'id_user' )\n" +
                "VALUES (\"Berlino\", \"Molto freddo\" ,1);");
        db.execSQL("INSERT INTO 'Travels' ('title', 'description' , 'id_user' )\n" +
                "VALUES (\"Bologna\", \"Viva le due torri\" ,1);");
        db.execSQL("INSERT INTO 'Travels' ('title', 'description' , 'id_user' )\n" +
                "VALUES (\"Cesenatico\", \"Buono il pesce\" ,1);");
        db.execSQL("INSERT INTO 'Travels' ('title', 'description' , 'id_user' )\n" +
                "VALUES (\"Ravenna\", \"Città carina\" ,1);");
        db.execSQL("INSERT INTO 'Travels' ('title', 'description' , 'id_user' )\n" +
                "VALUES (\"Ferrara\", \"Buon cibo\" ,1);");
        db.execSQL("INSERT INTO 'Travels' ('title', 'description' , 'id_user' )\n" +
                "VALUES (\"Milano\", \"Mila vs Bologna\" ,1);");
        db.execSQL("INSERT INTO 'Travels' ('title', 'description' , 'id_user' )\n" +
                "VALUES (\"Torino\", \"Droidcon\" ,1);");
    }

    /**
     * Metodo che mi aggiorna il database
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAMES[0]);
        //onCreate(db);
    }

    /**
     * Inserisco i dati dell' utente nel database
     * (Ulteriormente da migliorare)
     * @param arrayList
     * @return
     */
    public boolean insertDataUser(ArrayList arrayList) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        //contentValues.put("id",arrayList.get(0).toString());//nome
        contentValues.put("firstName",arrayList.get(0).toString());//nome
        contentValues.put("lastName",arrayList.get(1).toString());//cognome
        contentValues.put("username",arrayList.get(2).toString());//username
        contentValues.put("password",arrayList.get(3).toString());//password
        contentValues.put("email",arrayList.get(4).toString());//email
        contentValues.put("city",arrayList.get(5).toString());//città
        contentValues.put("country",arrayList.get(6).toString());//pease
        contentValues.put("gender",arrayList.get(7).toString());//sesso
        //contentValues.put("age",calcAge());//con birthdate calcolare l'età
        contentValues.put("birthdate",arrayList.get(8).toString());//data di nascita
        //contentValues.put("registration_date",new Date());//data di nascita
        //contentValues.put("last_login",arrayList.get(8).toString());//data di nascita
        long result = db.insert(TABLE_NAMES[0],null ,contentValues);
        return result != -1;
    }

    public boolean insertDataUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        //contentValues.put("id",arrayList.get(0).toString());//nome
        contentValues.put("firstName",user.getFirstName().toString());//nome
        contentValues.put("lastName",user.getLastName().toString());//cognome
        contentValues.put("username",user.getUsername().toString());//username
        contentValues.put("email",user.getEmail().toString());//email
        contentValues.put("password",user.getPassword().toString());//password
        contentValues.put("city",user.getCity().toString());//città
        contentValues.put("country",user.getCountry().toString());//pease
        contentValues.put("gender",user.getGender().toString());//sesso
        contentValues.put("birthdate",user.getBirthdate().toString());//data di nascita
        contentValues.put("age",user.getAge());//con birthdate calcolare l'età
        contentValues.put("imgProfilo",user.getImgUser());//immagine del profilo
        contentValues.put("last_login","datetime (CURRENT_TIMESTAMP, 'localtime')");//data ultimo login
        contentValues.put("registration_date","datetime (CURRENT_TIMESTAMP, 'localtime')");//data registrazione
        //contentValues.put("last_login",user.getLast_access().toString());//data ultimo login
        //contentValues.put("registration_date",user.getRegistration_date().toString());//data registrazione
        long result = db.insert(TABLE_NAMES[0],null ,contentValues);
        return result != -1;
    }

    /**
     * Metodo che aggiunge i dati della Immagine all'interno del database
     * @param picture
     * @return
     */
    public boolean inserDataImage(Picture picture){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("title",picture.getTitle());//data di nascita
        //contentValues.put("description",picture.getImage());//data di nascita
        contentValues.put("image",picture.getImage());//data di nascita
        contentValues.put("id_user",picture.getId_user());//data di nascita
        long result = db.insert(TABLE_NAMES[3],null ,contentValues);
        return result != -1;
    }

    /**
     * Metodo che aggiunge i dati della Nota all'interno del database
     * @param note
     * @return
     */
    public boolean insertDataNote(Note note){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("title",note.getTitle());//title
        contentValues.put("description",note.getDescription());//content
        contentValues.put("creation_data",note.getCreation_data().toString());//creation_date
        contentValues.put("id_user",note.getId_user());//id_user
        //contentValues.put(COL_TABLE[6],note.getId_travel());//id_travel
        //contentValues.put(COL_TABLE[7],note.getId_place());//id_place
        //contentValues.put(COL_TABLE[8],note.getId_picture());//id_picture
        long result = db.insert(TABLE_NAMES[2],null ,contentValues);
        return result != -1;
    }

    /**
     * Metodo che aggiunge i dati del Travel all'interno del database
     * @param travel
     * @return
     */
    public boolean insertDataTravel(Travel travel){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("title",travel.getTitle());//Inserisco il titolo
        //contentValues.put("",travel.getCategory());//Inserisco il titolo
        contentValues.put("description",travel.getDescription());//Inserisco il titolo
        contentValues.put("id_user",travel.getId_user());//Inserisco il titolo
        long result = db.insert(TABLE_NAMES[1],null ,contentValues);
        return result != -1;

    }

    /**
     * Ottengo tutti i dati della tabella richiesta
     * @param table
     * @return tutti i dati
     */
    public Cursor getAll(String table) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM "+ table ,null);
        return res;
    }


    /**
     * Costruzione del database HolidayDiary
     * @param db
     */
    private void createStructureDatabase(SQLiteDatabase db){
        //Creazione della tabella User
        crateUsersTable(db);
        //Creazione della tabella Travel
        createTravelsTable(db);
        //Creazione della tabella Note
        createNotesTable(db);
        //Creazione della tabella Picture
        createPicturesTable(db);
        //Creazione della tabella Position
        createPlacesTable(db);
    }

    /**
     * Costruzione della tabella Users
     * @param db
     */
    private void crateUsersTable(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS "+ TABLE_NAMES[0] + " (" +
                "id integer PRIMARY KEY AUTOINCREMENT," +
                "firstName text," +
                "lastName text," +
                "username text," +
                "email text not null," +
                "password text not null," +
                "city text," +
                "country text," +
                "gender text," +
                "birthdate DATE," +
                "age integer," +
                "imgProfilo integer," +
                "last_login DATETIME," +
                "registration_date DATETIME);");
    }


    /**
     * Costruzione della tabella Travels
     * @param db
     */
    private void createTravelsTable(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS "+ TABLE_NAMES[1] + " (" +
                "id integer PRIMARY KEY AUTOINCREMENT," +
                "title text not null," +
                "description text not null," +
                "img_list integer," +
                "city text," +
                "country text," +
                "start_travel Date," +
                "finish_travel Date," +
                "registration_date Date," +
                "id_user integer not null," +
                "id_place integer," +
                "foreign key (id_user) references "+ TABLE_NAMES[0] +" (id)," +
                "foreign key (id_place) references "+ TABLE_NAMES[4] +" (id));");
    }

    private void insertTravels(SQLiteDatabase db){
        db.execSQL("INSERT INTO 'Users' ('title' , 'description' , 'img_list' , 'city' , 'country' , 'id_user' , 'id_place')" +
                "VALUES ('Nota Ciao' , 'Ciao a tutti come va la vita?' , '1' , 'Venezia' , 'Italia' , '1' , '1');");
        db.execSQL("INSERT INTO 'Users' ('title' , 'description' , 'img_list' , 'city' , 'country' , 'id_user' , 'id_place')" +
                "VALUES ('Nota 2 Bella' , 'La vita è bella' , '1' , 'Venezia' , 'Italia' , '2', '2');");
    }

    /**
     * Costruzione della tabella Notes
     * @param db
     */
    private void createNotesTable(SQLiteDatabase db){
        db.execSQL("CREATE TABLE IF NOT EXISTS "+ TABLE_NAMES[2] + " (" +
                "id integer PRIMARY KEY AUTOINCREMENT," +
                "title text not null," +
                "description text not null," +
                "creation_data DATA," +
                "id_user integer not null," +
                "id_travel integer," +
                "id_place integer," +
                "id_picture integer," +
                "foreign key (id_user) references "+ TABLE_NAMES[0] +" (id)," +
                "foreign key (id_travel) references "+ TABLE_NAMES[1] +" (id)," +
                "foreign key (id_picture) references "+ TABLE_NAMES[3] +" (id)," +
                "foreign key (id_place) references "+ TABLE_NAMES[4] +" (id));");
    }

    /**
     * Costruzione della tabella Pictures
     * @param db
     */
    private void createPicturesTable(SQLiteDatabase db){
        db.execSQL("CREATE TABLE "+ TABLE_NAMES[3] + " (" +
                "id integer PRIMARY KEY," +
                "title text not null," +
                "description text," +
                "image BLOB not null," +
                "id_user text not null," +
                "id_travel integer," +
                "id_place integer," +
                "foreign key (id_user) references "+ TABLE_NAMES[0] +" (id)," +
                "foreign key (id_travel) references "+ TABLE_NAMES[1] +" (id)," +
                "foreign key (id_place) references "+ TABLE_NAMES[4] +" (id));");
    }

    /**
     * Costruzione della tabella Places
     * @param db
     */
    private void createPlacesTable(SQLiteDatabase db){
        db.execSQL("CREATE TABLE IF NOT EXISTS "+ TABLE_NAMES[4] + " (" +
                "id integer PRIMARY KEY AUTOINCREMENT," +
                "title text," +
                "description text," +
                "latitude integer not null," +
                "longitude integer not null," +
                "city text," +
                "country text," +
                "creation_data DATA," +
                "id_user text not null," +
                "foreign key (id_user) references "+ TABLE_NAMES[0] +" (id));");
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
     * Ottengo tutti i dati di una nota precisa con i seguenti parametri
     * @param email
     * @param password
     * @return
     */
    public Cursor getDataNote(String email,String password) {
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
        contentValues.put("id",id);
        contentValues.put("firstName",firstName);
        contentValues.put("lastName",lastName);
        contentValues.put("username",username);
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

    private void addDataOnDatabase(SQLiteDatabase db){

        //Aggiungo Users
        //insertUsers(db);

        //Aggiungo Travels
        insertTravels(db);
        //Aggiungo Notes

        //Aggiungo Pictures

        //Aggiungo Places

    }

}
