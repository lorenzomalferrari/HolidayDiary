package com.lorenzomalferrari.holidaydiary.control;

// Android library
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
// My library
import com.lorenzomalferrari.holidaydiary.model.Note;
import com.lorenzomalferrari.holidaydiary.model.Picture;
import com.lorenzomalferrari.holidaydiary.model.Travel;
import com.lorenzomalferrari.holidaydiary.model.User;
// Java library
import java.util.ArrayList;

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
     * Costruttore parametrico
     * Inizializza l'oggetto con il contesto della Activity dove viene creato  e si collega al database voluto
     * @param context
     */
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    /**
     * Creazione del database con le tabelle
     * @param db viene passato l'oggetto del database
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        //Creazione del Database
        createStructureDatabase(db);
        //Aggiunta di dati nel databse (Uso per test iniziali)
        //addDataDatabase(db);
    }

    /**
     * Aggiunta di dati nelle tabelle
     * Aggiunta di dati del db per testare il corretto funzionamento della connessione al db
     * @param db viene passato l'oggetto del database
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
     * Metodo che aggiorna il database
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
     * Inserisce i dati dell' utente nel database
     * (Ulteriormente da migliorare)
     * @param arrayList
     * @return true se l'inserimento è andato a buon fine, false se non è andato a buon fine
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

    /**
     * Inserisce i dati dell'utente del db
     * @param user
     * @return true se l'inserimento è andato a buon fine, false se non è andato a buon fine
     */
    public boolean insertDataUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        //contentValues.put("id",arrayList.get(0).toString());//nome
        contentValues.put("firstName", user.getFirstName());//nome
        contentValues.put("lastName", user.getLastName());//cognome
        contentValues.put("username", user.getUsername());//username
        contentValues.put("email", user.getEmail());//email
        contentValues.put("password", user.getPassword());//password
        contentValues.put("city", user.getCity());//città
        contentValues.put("country", user.getCountry());//pease
        contentValues.put("gender", user.getGender());//sesso
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
     * Inserisce l'immagine all'interno del db
     * @param picture
     * @return true se l'inserimento è andato a buon fine, false se non è andato a buon fine
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
     * Inserisce la nota all'interno del db
     * @param note
     * @return true se l'inserimento è andato a buon fine, false se non è andato a buon fine
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
     * Inserisce il viaggio all'interno del db
     * @param travel
     * @return true se l'inserimento è andato a buon fine, false se non è andato a buon fine
     */
    public boolean insertDataTravel(Travel travel){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("title",travel.getTitle());//Inserisco il titolo
        contentValues.put("category",travel.getCategory());//Inserisco il titolo
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
    public Cursor getAll(String table,int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM "+ table,null);
        return res;
    }

    /**
     * Costruisce il database HolidayDiary
     * @param db viene passato l'oggetto del database
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
     * @param db viene passato l'oggetto del database
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
     * @param db viene passato l'oggetto del database
     */
    private void createTravelsTable(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS "+ TABLE_NAMES[1] + " (" +
                "id integer PRIMARY KEY AUTOINCREMENT," +
                "title text not null," +
                "category text," +
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

    /**
     * Iscerisce all'interno del db Travels viaggi pre-costruiti
     * @param db viene passato l'oggetto del database
     */
    private void insertTravels(SQLiteDatabase db){
        db.execSQL("INSERT INTO" + TABLE_NAMES[1] + " ('title' , 'description' , 'img_list' , 'city' , 'country' , 'id_user' , 'id_place')" +
                "VALUES ('Nota Ciao' , 'Ciao a tutti come va la vita?' , '1' , 'Venezia' , 'Italia' , '1' , '1');");
        db.execSQL("INSERT INTO" + TABLE_NAMES[1] + " ('title' , 'description' , 'img_list' , 'city' , 'country' , 'id_user' , 'id_place')" +
                "VALUES ('Nota 2 Bella' , 'La vita è bella' , '1' , 'Venezia' , 'Italia' , '2', '2');");
    }

    /**
     * Costruzione della tabella Notes
     * @param db viene passato l'oggetto del database
     */
    private void createNotesTable(SQLiteDatabase db){
        db.execSQL("CREATE TABLE IF NOT EXISTS "+ TABLE_NAMES[2] + " (" +
                "id integer PRIMARY KEY AUTOINCREMENT," +
                "title text not null," +
                "description text not null," +
                "creation_data DATA DEFAULT (datetime('now','localtime'))," +
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
     * @param db viene passato l'oggetto del database
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
     * @param db viene passato l'oggetto del database
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
     * @param email email di user
     * @param password password di user
     * @return
     */
    public Cursor getDataUser(String email,String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM "+TABLE_NAMES[0] + " WHERE email = '"+email+"' AND password = '"+password+"'",null);
        return res;
    }

    /**
     * Ottengo tutti i dati di una nota precisa con i seguenti parametri
     */
    /*public Cursor getDataNote(String email,String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM "+TABLE_NAMES[0] + " WHERE email = '"+email+"' AND password = '"+password+"'",null);
        return res;
    }*/

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
     * Elimina riga da Tabella
     * @param table nome della tabella
     * @param id id del campo che si vuole eliminare
     * @return 1 se riga eliminata, 0 se non viene eliminata nessuna riga
     */
    public Integer deleteData (String table, String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(table, "ID = ?",new String[] {id});
    }

    /**
     * Elimina tutto il db
     * @param db viene passato l'oggetto del database
     * @return
     */
    // Da implementare
    public boolean deleteDatabase(String db){
        boolean flag = true;
        SQLiteDatabase database = this.getWritableDatabase();
        //database.
        return flag;
    }

    /**
     * Aggiunge dati nel database
     * @param db viene passato l'oggetto del database
     */
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
