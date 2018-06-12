package com.lorenzomalferrari.holidaydiary.control;
// Android library
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
// My library
import com.lorenzomalferrari.holidaydiary.view.activity.LoginActivity;
// Java library
import java.util.HashMap;

/**
 *
 * @author Lorenzo Malferrari - Website: www.lorenzomalferrari.com
 */
public class UserSessionManager {

    // Create object of SharedPreferences
    SharedPreferences sharedPref;
    //Now get Editor
    SharedPreferences.Editor editor;
    // Context
    Context _context;
    // Shared pref mode
    int PRIVATE_MODE = 0;
    // Sharedpref file name
    private static final String PREFER_NAME = "dataLogin";
    // All Shared Preferences Keys
    private static final String IS_USER_LOGIN = "IsUserLoggedIn";
    // Password (make variable public to access from outside)
    private static final String KEY_PASSWORD = "password";
    // Email address (make variable public to access from outside)
    private static final String KEY_EMAIL = "email";

    // Constructor
    public UserSessionManager(Context context){
        this._context = context;
        sharedPref = PreferenceManager.getDefaultSharedPreferences(_context);
        sharedPref = _context.getSharedPreferences(PREFER_NAME, PRIVATE_MODE);
        editor = sharedPref.edit();
    }

    /**
     *
     * @param email
     * @param password
     */
    public void createUserLoginSession(String email, String password){
        // Storing email in pref
        editor.putString(KEY_EMAIL, email);
        // Storing password in pref
        editor.putString(KEY_PASSWORD, password);
        // Storing login value as TRUE
        editor.putBoolean(IS_USER_LOGIN, true);
        // commit changes
        editor.commit();
    }

    /**
     * Check login method will check user login status
     * If false it will redirect user to login page
     * Else do anything
     * */
    public boolean checkLogin(){
        // Check login status
        if(!this.isUserLoggedIn()){
            // user is not logged in redirect him to Login Activity
            Intent i = new Intent(_context, LoginActivity.class);
            // Closing all the Activities from stack
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            // Add new Flag to start new Activity
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            // Staring Login Activity
            _context.startActivity(i);
            return true;
        }
        return false;
    }

    /**
     * Get stored session data
     */
    public HashMap<String, String> getUserDetails(){
        //Use hashmap to store user credentials
        HashMap<String, String> user = new HashMap<>();
        // user email
        user.put(KEY_EMAIL, sharedPref.getString(KEY_EMAIL, null));
        // user password
        user.put(KEY_PASSWORD, sharedPref.getString(KEY_PASSWORD, null));
        // return user details
        return user;
        //Come recuperare
        //SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        //String userName = sharedPref.getString("userName", "Not Available");
    }

    /**
     * Clear session details
     */
    public void logoutUser(){
        // Clearing all user data from Shared Preferences and commit it
        editor.clear();
        editor.commit();
        // After logout redirect user to Login Activity
        Intent intent = new Intent(_context, LoginActivity.class);
        // Closing all the Activities
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        // Add new Flag to start new Activity
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        // Staring Login Activity
        _context.startActivity(intent);
    }

    // Check for login
    public boolean isUserLoggedIn(){
        return sharedPref.getBoolean(IS_USER_LOGIN, false);
    }
}