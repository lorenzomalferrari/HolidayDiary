package com.lorenzomalferrari.holidaydiary.model;

import android.util.Patterns;
import android.widget.EditText;

import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Classe che controlla che i dati sia validi, ovvero email password etc.....
 */
public class Validator {

    /**
     *
     * @return
     */
    /*public boolean isValidLogin(String email,String password){
        if (isEmailValid(email) == true && isPasswordValid(password) == true){
            return true;
        }
        else {
            return true;
        }
    }*/

    /**
     * Metodo che controlla che il nome e cognome sia composto solamente da lettere
     * @param firstName
     * @param lastName
     * @return
     */
    public boolean isNameValid(String firstName, String lastName){
        //Array dei char di firstName
        String[] firstNameSplit = firstName.split("");
        //Array dei char di lastName
        String[] lastNameSplit = lastName.split("");
        //boolean var
        boolean flag = false;

        //Controllo firstName
        for (int i = 0; i <= firstNameSplit.length; i ++){
            try
            {
                double d = Double.parseDouble(firstNameSplit[0]);
            }
            catch(NumberFormatException nfe)
            {
                flag = false;
            }
            flag = true;
        }

        //Controllo lastName
        for (int i = 0; i <= lastNameSplit.length; i ++){
            try
            {
                double d = Double.parseDouble(lastNameSplit[0]);
            }
            catch(NumberFormatException nfe)
            {
                flag = false;
            }
            flag = true;
        }
        return flag;
    }

    /**
     * Controllo che il campo username non sia vuoto
     * @param username
     * @return true se non è vuoto || false se è campo è vuoto
     */
    public boolean isUsernameEmpty(String username){
        if (username.trim().length() > 0) return true;
        else return false;
    }

    /**
     * Controllo che la password rispetti Patterns.EMAIL_ADDRESS
     * @return true = password ok || false = pawword !ok
     */
    public boolean isEmailValid(String email) {
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    /**
     * La password deve essere >= 6
     * @return
     */
    public boolean isPasswordValid(String password) {
        return password.length() >= 6;
    }

    public boolean isFieldsEmpty(String email, String password){
        if (email.trim().length() > 0 && password.trim().length() > 0)
        {
            return true;
        }
        else return false;
    }

    /**
     * Metodo che mi controlla che l'età non sia negativa
     * @param age
     * @return true se età > 0 else se età <= 0
     */
    private boolean isAgeNegative(int age){
        if (age <= 0){
            return false;
        }
        else return true;
    }

    /**
     * Controllo che il valore non sia null ma che contenga qualcosa
     * @param string
     * @return false = null || true = string
     */
    /*public boolean isEmpty(String string) {
        if (string.isEmpty()){
            return true;
        }
        else {
            return false;
        }
    }*/

    public int calcAGe(){
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        Calendar oggi = Calendar.getInstance();
        // dataDiNascita.getYear(); METODO DEPRECATO!!
        return oggi.get(Calendar.YEAR) - c.get(Calendar.YEAR);
    }
}
