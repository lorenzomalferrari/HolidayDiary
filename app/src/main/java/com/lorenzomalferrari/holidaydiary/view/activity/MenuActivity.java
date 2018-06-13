package com.lorenzomalferrari.holidaydiary.view.activity;
// Android library
import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
// github.clans.fab library
import com.github.clans.fab.FloatingActionMenu;
import com.github.clans.fab.FloatingActionButton;
// My library
import com.lorenzomalferrari.holidaydiary.R;
import com.lorenzomalferrari.holidaydiary.control.Controller;
import com.lorenzomalferrari.holidaydiary.control.UserSessionManager;
import com.lorenzomalferrari.holidaydiary.control.DatabaseHelper;
import com.lorenzomalferrari.holidaydiary.view.fragment.HomePageFragment;


public class MenuActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    //
    Controller controller;
    //
    Dialog myDialog;
    UserSessionManager userSessionManager;
    DatabaseHelper databaseHelper;
    Cursor res;
    Intent intentMenu;
    //
    TextView user,email_author;
    FloatingActionMenu floatingActionMenu;
    FloatingActionButton travel,note,picture,place;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        controller = new Controller();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Session class instance
        userSessionManager = new UserSessionManager(getApplicationContext());
        //
        databaseHelper = new DatabaseHelper(this);
        intentMenu = getIntent();
        intentMenu.putExtra("email",userSessionManager.getUserDetails().get("email"));
        intentMenu.putExtra("password",userSessionManager.getUserDetails().get("password"));
        res = databaseHelper.getDataUser(intentMenu.getStringExtra("email"),intentMenu.getStringExtra("password"));

        DrawerLayout drawer = findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        // Check UserSessionManager
        checkUserSession();
        // Inizializzazione dei componenti
        init();
        //Esecuzione dei bottoni
        actionTravel();
        actionNote();
        actionPicture();
        actionPlace();
    }

    /**
     * Inizializzazione degli attributi dei componenti
     */
    private void init() {
        floatingActionMenu = findViewById(R.id.floatingActionMenu);
        travel = findViewById(R.id.floatingActionButtonTravel);
        note = findViewById(R.id.floatingActionButtonNote);
        picture = findViewById(R.id.floatingActionButtonPicture);
        place = findViewById(R.id.floatingActionButtonPlace);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        //set data in nav_header_menu
        //setDataUser();
        user = findViewById(R.id.nav_header_menu_user);
        email_author = findViewById(R.id.nav_header_menu_email);
        while (res.moveToNext()){
            user.setText(res.getString(1) + " "+ res.getString(2));
            email_author.setText(res.getString(4));
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        /*if (id == R.id.action_logout) {
            //Eseguo il logout
            userSessionManager.logoutUser();
            return true;
        }*/
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        //calling the method displayselectedscreen and passing the id of selected menu
        displaySelectedScreen(item.getItemId());
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        //make this method blank
        return true;
    }

    /**
     * Compilo le chiamate delle voci presenti nel menù
     * @param itemId
     */
    private void displaySelectedScreen(int itemId) {
        //creating fragment object
        Fragment fragment = null;
        //creating intent object
        Intent intent = null;
        int id = 0;
        while (res.moveToNext()){
            id = res.getInt(0);
        }

        //initializing the fragment object which is selected
        switch (itemId) {
            case R.id.nav_homepage:
                //fragment = new HomePageFragment();
                break;
            case R.id.nav_travels:
                intent = new Intent(this, TravelsActivity.class);
                intent.putExtra("id_user",id);
                this.startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                break;
            case R.id.nav_notes:
                intent = new Intent(this, NotesActivity.class);
                intent.putExtra("id_user",id);
                this.startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                break;
            case R.id.nav_pictures:
                intent = new Intent(this, PicturesActivity.class);
                intent.putExtra("id_user",id);
                this.startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                break;
            case R.id.nav_places:
                intent = new Intent(this, MyPositionActivity.class);
                intent.putExtra("id_user",id);
                this.startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                break;
            case R.id.nav_reservation:
                break;
            case R.id.nav_account:
                intent = new Intent(getApplicationContext(), AccountActivity.class);
                intent.putExtra("email",intentMenu.getStringExtra("email"));
                intent.putExtra("password",intentMenu.getStringExtra("password"));
                this.startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                break;
            case R.id.nav_settings:
                intent = new Intent(getApplicationContext(), SettingsActivity.class);
                intent.putExtra("id_user",id);
                this.startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                break;
            case R.id.nav_privacytermsofuse:
                intent = new Intent(this, PrivacyTermsActivity.class);
                this.startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                break;
            case R.id.nav_version:
                myDialog = new Dialog(this);
                ShowPopup();
                break;
        }

        //replacing the fragment
        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment);
            ft.commit();
        }
    }

    /**
     * Mostra il popup con i dati della versione
     */
    private void ShowPopup(){
        TextView txtClose;
        myDialog.setContentView(R.layout.versionpopup);
        txtClose = myDialog.findViewById(R.id.txtClose);
        txtClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }

    /**
     * Controllo i dati della sessione utente
     */
    private void checkUserSession(){
        // Check user login
        // If User is not logged in , This will redirect user to LoginActivity.
        if(userSessionManager.checkLogin()) finish();
    }

    private void setDataUser(){

        // get user data from session
        //HashMap<String, String> user = userSessionManager.getUserDetails();
        // get password
        //String password = user.get(UserSessionManager.KEY_PASSWORD);
        // get email
        //String email = user.get(UserSessionManager.KEY_EMAIL);

        // ottengo tutti i dati di utente che ha password e email della session
        databaseHelper = new DatabaseHelper(this);
        //Cursor res = databaseHelper.getDataUser(email,password);

        // Cambio il testo nav_header_menu
        // Cambio nav_header_menu_imgUser
        //ImageView imgUser = findViewById(R.id.nav_header_menu_imgUser);
        //imgUser.setImageResource(R.drawable.v_0579);
        // Cambio nav_header_menu_user
        //TextView name = findViewById(R.id.nav_header_menu_user);
        //name.setText(res.getString(1).toString()+" "+res.getString(2).toString());
        //name.setText(password);
        // Cambio nav_header_menu_email
        //TextView emailUser = findViewById(R.id.nav_header_menu_email);
        //emailUser.setText(res.getString(5).toString());
        //emailUser.setText(email);
    }

    /**
     * Chiamo l'attività per visualizzare la lista dei viaggi
     */
    private void actionTravel(){
        travel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, AddTravelActivity.class);
                MenuActivity.this.startActivity(intent);
                // Pulisco la visualizzazione dei bottoni
                closeFloatingActionMenu();
            }
        });
    }

    /**
     * Chiamo l'attività per visualizzare la lista delle note
     */
    private void actionNote(){
        note.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, AddNoteActivity.class);
                MenuActivity.this.startActivity(intent);
                // Pulisco la visualizzazione dei bottoni
                closeFloatingActionMenu();
            }
        });
    }

    /**
     * Chiamo l'attività per visualizzare la lista delle immagini
     */
    private void actionPicture(){
        picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, AddPictureActivity.class);
                MenuActivity.this.startActivity(intent);
                // Pulisco la visualizzazione dei bottoni
                closeFloatingActionMenu();
            }
        });
    }

    /**
     * Chiamo l'attività per visualizzare la lista dei luoghi
     */
    private void actionPlace(){
        place.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Pulisco la visualizzazione dei bottoni
                closeFloatingActionMenu();
            }
        });
    }

    /**
     * Chiudo il menu
     */
    private void closeFloatingActionMenu(){
        floatingActionMenu.setAnimated(false);
        floatingActionMenu.close(false);
    }

}
