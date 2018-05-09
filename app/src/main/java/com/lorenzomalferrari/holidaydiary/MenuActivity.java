package com.lorenzomalferrari.holidaydiary;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.Html;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.lorenzomalferrari.holidaydiary.control.UserSessionManager;

import java.util.HashMap;

public class MenuActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Dialog myDialog;
    UserSessionManager userSessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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

        //set data in nav_header_menu
        //setData();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
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
                //fragment = new TravelsFragment();
                break;
            case R.id.nav_notes:
                //fragment = new NotesFragment();
                break;
            case R.id.nav_pictures:
                //fragment = new PicturesFragment();
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

        // get user data from session
        HashMap<String, String> user = userSessionManager.getUserDetails();

        // get password
        String password = user.get(UserSessionManager.KEY_PASSWORD);

        // get email
        String email = user.get(UserSessionManager.KEY_EMAIL);

        // Show user data on activity
        //lblName.setText(Html.fromHtml("Name: <b>" + name + "</b>"));
        //lblEmail.setText(Html.fromHtml("Email: <b>" + email + "</b>"));

    }

    /**
     * Setto con i dati che ricevo dalla UserSessionManager la nav_header_menu.xml
     */
    private void setData(){


        // get user data from session
        HashMap<String, String> user = userSessionManager.getUserDetails();
        // get password
        String password = user.get(UserSessionManager.KEY_PASSWORD);
        // get email
        String email = user.get(UserSessionManager.KEY_EMAIL);


        //Setto img

        /* Setto nome e cognome */

        /* Setto il campo email nella activity con il valore preso salla session */
        TextView textView = findViewById(R.id.nav_header_menu_email);
        textView.setText(email);

    }
}
