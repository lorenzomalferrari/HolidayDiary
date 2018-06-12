package com.lorenzomalferrari.holidaydiary.control;

import android.util.Patterns;
import android.widget.EditText;

import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Classe che controlla che i dati sia validi, ovvero email password etc.....
 *
 * @author Lorenzo Malferrari - Website: www.lorenzomalferrari.com
 */
public class Validator {

    /**
     * Costruttore di default
     */
    public Validator() {
        // Set attributes
    }

    /**
     * Controllo che i campi email e password non siano vuoti
     * @param email
     * @param password
     * @return true se non sono vuoti, false se sono vuoti
     */
    public boolean isFieldsEmpty(String email, String password){
        if (email.trim().length() > 0 && password.trim().length() > 0)
        {
            return true;
        }
        else return false;
    }

    //Controllo nome e cognome
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
        boolean flag_firstName = false;
        boolean flag_lastName = false;

        //Controllo firstName
        for (int i = 0; i <= firstNameSplit.length; i ++){
            try
            {
                double d = Double.parseDouble(firstNameSplit[0]);
            }
            catch(NumberFormatException nfe)
            {
                flag_firstName = false;
            }
            flag_firstName = true;
        }

        //Controllo lastName
        for (int i = 0; i <= lastNameSplit.length; i ++){
            try
            {
                double d = Double.parseDouble(lastNameSplit[0]);
            }
            catch(NumberFormatException nfe)
            {
                flag_lastName = false;
            }
            flag_lastName = true;
        }
        return (flag_firstName && flag_lastName);
    }

    //Controllo username
    /**
     * Controllo che il campo username non sia vuoto
     * @param username
     * @return true se non è vuoto || false se è campo è vuoto
     */
    public boolean isUsernameEmpty(String username){
        if (username.trim().length() > 0) return true;
        else return false;
    }

    //Controllo email
    /**
     * Controllo che la password rispetti Patterns.EMAIL_ADDRESS
     * @return true = password ok || false = pawword !ok
     */
    public boolean isEmailValid(String email) {
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    //Controllo password
    /**
     * La password deve essere >= 6
     * @return
     */
    public boolean isPasswordValid(String password) {
        return password.length() >= 6;
    }

    //Controllo città

    //Controllo paese

    //Controllo gender

    //Controllo compleanno

    /**
     * Calcola l'età dell'utente usando come parametro d'ingresso la data di nascita
     * @param data
     * @return
     */
    public int calcAge(Date data){
        int age = 0;
        Calendar  myData = Calendar.getInstance();
        myData.setTime(data);
        //System.out.println("Mia data secondo Calendar " + (myData.get(Calendar.YEAR) + "/" + (myData.get(Calendar.MONTH)+1) + "/" +myData.get(Calendar.DAY_OF_MONTH)));
        Calendar today = Calendar.getInstance();
        int year = today.get(Calendar.YEAR) - myData.get(Calendar.YEAR);
        int month = (today.get(Calendar.MONTH)+1) - (myData.get(Calendar.MONTH)+1);
        int day_of_month = today.get(Calendar.DAY_OF_MONTH) - myData.get(Calendar.DAY_OF_MONTH);
        //System.out.println("Data di oggi " + (today.get(Calendar.YEAR) + "/" + (today.get(Calendar.MONTH)+1) + "/" +today.get(Calendar.DAY_OF_MONTH)));
        //System.out.println("Year: " + year);
        //System.out.println("Month: " + month);
        //System.out.println("Day: " + day_of_month);

        if (year > 0){
            if (month > 0){
                //if (day_of_month > 0)
                age = year;
                //else age = year - 1;
            }
            else age = year - 1;
        }
        else {
            //Impossibile, la persona deve ancora nascere
        }
        return age;
    }

    //Controllo che l'ètà non sia negativa
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



    public boolean isBirthdateValid() {
        return false;
    }
}
