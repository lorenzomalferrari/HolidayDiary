package com.lorenzomalferrari.holidaydiary.model;

import java.util.Date;

/**
 *
 * @author Lorenzo Malferrari - www.lorenzomalferrari.com
 */
public class User {

    // Attributi della tabella Users presente sul database HolidayDiary.db
    private int id, age, imgUser;
    private String firstName, lastName, username, email, password, city, country, gender;
    private Date birthdate, last_access, registration_date;

    /**
     * Costruttore di default:
     * Costruisce un oggetto User con valori predefiniti
     */
    public User() {
        this.firstName = "Lorenzo";
        this.lastName = "Malferrari";
        this.username = "malfe.lore@gmail.com";
        this.email = "malfe.lore@gmail.com";
        this.password = "123456";
        this.city = "Bologna";
        this.country = "Italia";
        this.gender = "Maschio";
        this.birthdate = new Date();
        this.age = 21;
        this.imgUser = 1;
        this.last_access = new Date();
        this.registration_date = new Date();
    }

    /**
     * Costruttore parametrico parziale:
     * Costruzione dell'oggetto con tutti i suoi campi escluso l'id
     * @param firstName
     * @param lastName
     * @param username
     * @param email
     * @param password
     * @param city
     * @param country
     * @param gender
     * @param imgUser
     * @param birthdate
     * @param last_access
     * @param registration_date
     */
    public User(String firstName, String lastName, String username, String email, String password, String city, String country, String gender,Date birthdate, int age, int imgUser,  Date last_access, Date registration_date) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.city = city;
        this.country = country;
        this.gender = gender;
        this.birthdate = birthdate;
        this.age = age;
        this.imgUser = imgUser;
        this.last_access = last_access;
        this.registration_date = registration_date;
    }

    /**
     * Costrutore parametrico completo:
     * Costruzione dell'oggetto User con tutti i suoi attributi
     * @param id
     * @param firstName
     * @param lastName
     * @param username
     * @param email
     * @param password
     * @param city
     * @param country
     * @param gender
     * @param imgUser
     * @param birthdate
     * @param last_access
     * @param registration_date
     */
    public User(int id,String firstName, String lastName, String username, String email, String password, String city, String country, String gender, Date birthdate, int age, int imgUser,  Date last_access, Date registration_date) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.city = city;
        this.country = country;
        this.gender = gender;
        this.birthdate = birthdate;
        this.age = age;
        this.imgUser = imgUser;
        this.last_access = last_access;
        this.registration_date = registration_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImgUser() {
        return imgUser;
    }

    public void setImgUser(int imgUser) {
        this.imgUser = imgUser;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getLast_access() {
        return last_access;
    }

    public void setLast_access(Date last_access) {
        this.last_access = last_access;
    }

    public Date getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(Date registration_date) {
        this.registration_date = registration_date;
    }

    /**
     * Rappresentazione testuale della classe User
     * @return i dati dell'utente
     */
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", imgUser=" + imgUser +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", gender='" + gender + '\'' +
                ", birthdate=" + birthdate +
                ", age=" + age +
                ", last_access=" + last_access +
                ", registration_date=" + registration_date +
                '}';
    }
}
