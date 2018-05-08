package com.lorenzomalferrari.holidaydiary.model;

import android.util.Patterns;
import android.widget.EditText;

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
    public boolean isEmpty(String string) {
        if (string.isEmpty()){
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Controllo che nella stringa non ci siano numeri
     * @param stringa
     * @return
     */
    public boolean containsNumer(String stringa){
        boolean flag = false;
        String[] stringSplit = stringa.split("");
        for (int i = 0; i <= stringSplit.length;i ++){
            try {
                int isString = Integer.parseInt(stringSplit[i]);
                flag = true;
            }
            catch (NumberFormatException e){
                flag =  false;
                break;
            }
        }
        return flag;
    }
}
