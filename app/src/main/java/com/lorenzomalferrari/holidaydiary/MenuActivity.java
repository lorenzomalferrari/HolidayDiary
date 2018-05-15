package com.lorenzomalferrari.holidaydiary;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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
import android.widget.ImageView;
import android.widget.TextView;

import com.lorenzomalferrari.holidaydiary.control.Controller;
import com.lorenzomalferrari.holidaydiary.control.UserSessionManager;
import com.lorenzomalferrari.holidaydiary.control.DatabaseHelper;

import java.util.HashMap;

public class MenuActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Dialog myDialog;
    UserSessionManager userSessionManager;
    Controller controller;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        controller = new Controller();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        //check UserSessionManager
        checkUserSession();


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
        setDataUser();
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_logout) {
            //Eseguo il logout
            userSessionManager.logoutUser();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        //calling the method displayselectedscreen and passing the id of selected menu
        displaySelectedScreen(item.getItemId());
        //make this method blank
        return true;
    }

    private void displaySelectedScreen(int itemId) {
        //creating fragment object
        Fragment fragment = null;
        Intent intent = null;

        //initializing the fragment object which is selected
        switch (itemId) {
            case R.id.nav_homepage:
                //fragment = new HomePageFragment();
                break;
            case R.id.nav_travels:
                intent = new Intent(this, TravelsActivity.class);
                this.startActivity(intent);
                break;
            case R.id.nav_notes:
                intent = new Intent(this, NotesActivity.class);
                this.startActivity(intent);
                break;
            case R.id.nav_pictures:
                intent = new Intent(this, AddImageActivity.class);
                this.startActivity(intent);
                break;
            case R.id.nav_places:
                intent = new Intent(this, MyPositionActivity.class);
                this.startActivity(intent);
                break;
            case R.id.nav_account:
                fragment = new AccountFragment();
                //intent = new Intent(this, AccountActivity.class);
                //this.startActivity(intent);
                break;
            case R.id.nav_settings:
                //fragment = new SettingsFragment();
                break;
            case R.id.nav_privacytermsofuse:
                fragment = new PrivacyTermsFragment();
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

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }

    public void ShowPopup(){
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

    private void checkUserSession(){
        // Session class instance
        userSessionManager = new UserSessionManager(getApplicationContext());

        /*Toast.makeText(getApplicationContext(),
                "User Login Status: " + userSessionManager.isUserLoggedIn(),
                Toast.LENGTH_LONG).show();*/

        // Check user login
        // If User is not logged in , This will redirect user to LoginActivity.
        if(userSessionManager.checkLogin())
            finish();

    }

    private void setDataUser(){


        // get user data from session
        HashMap<String, String> user = userSessionManager.getUserDetails();
        // get password
        String password = user.get(UserSessionManager.KEY_PASSWORD);
        // get email
        String email = user.get(UserSessionManager.KEY_EMAIL);

        // ottengo tutti i dati di utente che ha password e email della session
        databaseHelper = new DatabaseHelper(this);
        Cursor res = databaseHelper.getDataUser(email,password);

        // Cambio il testo nav_header_menu
        // Cambio nav_header_menu_imgUser
        ImageView imgUser = findViewById(R.id.nav_header_menu_imgUser);
        //imgUser.setImageResource(R.drawable.v_0579);
        // Cambio nav_header_menu_user
        TextView name = findViewById(R.id.nav_header_menu_user);
        //name.setText(res.getString(1).toString()+" "+res.getString(2).toString());
        //name.setText(password);
        // Cambio nav_header_menu_email
        TextView emailUser = findViewById(R.id.nav_header_menu_email);
        //emailUser.setText(res.getString(5).toString());
        //emailUser.setText(email);
    }

}
