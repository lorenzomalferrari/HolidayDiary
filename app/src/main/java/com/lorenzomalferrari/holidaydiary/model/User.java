package com.lorenzomalferrari.holidaydiary.model;

import java.util.Date;

/**
 *
 * @author Lorenzo Malferrari - www.lorenzomalferrari.com
 */
public class User {

    // Attributi della tabella Users presente sul database HolidayDiary.db
    private int id;
    private String firstName, lastName, username, email, password, city, country;
    private char gender;
    private Date birthdate;
    private int imgUser;
    private Date last_access, registration_date;
    private int id_travel, id_note, id_picture, id_place;

    /**
     * Costruttore di default
     * Costruisco un oggetto con dati prescelti
     */
    public User() {
        this.id = 1;
        this.firstName = "Lorenzo";
        this.lastName = "Malferrari";
        this.username = "";
        this.email = "malfe.lore@gmail.com";
        this.password = "123456";
        this.city = "Bologna";
        this.country = "Italy";
        this.gender = 'M';
        this.birthdate = new Date();
        this.imgUser = 1;
        this.last_access = new Date();
        this.registration_date = new Date();
        this.id_travel = 1;
        this.id_note = 1;
        this.id_picture = 1;
        this.id_place = 1;
    }

    /**
     * Costruttore parametrico
     * Inizializzo gli attributi della classe con i prametri d'ingreso
     * @param id
     * @param firstName
     * @param lastName
     * @param username
     * @param email
     * @param password
     * @param city
     * @param country
     * @param gender
     * @param birthdate
     * @param imgUser
     * @param last_access
     * @param registration_date
     * @param id_travel
     * @param id_note
     * @param id_picture
     * @param id_place
     */
    public User(int id, String firstName, String lastName, String username, String email, String password, String city, String country, char gender, Date birthdate, int imgUser, Date last_access, Date registration_date, int id_travel, int id_note, int id_picture, int id_place) {
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
        this.imgUser = imgUser;
        this.last_access = last_access;
        this.registration_date = registration_date;
        this.id_travel = id_travel;
        this.id_note = id_note;
        this.id_picture = id_picture;
        this.id_place = id_place;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public int getImgUser() {
        return imgUser;
    }

    public void setImgUser(int imgUser) {
        this.imgUser = imgUser;
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

    public int getId_travel() {
        return id_travel;
    }

    public void setId_travel(int id_travel) {
        this.id_travel = id_travel;
    }

    public int getId_note() {
        return id_note;
    }

    public void setId_note(int id_note) {
        this.id_note = id_note;
    }

    public int getId_picture() {
        return id_picture;
    }

    public void setId_picture(int id_picture) {
        this.id_picture = id_picture;
    }

    public int getId_place() {
        return id_place;
    }

    public void setId_place(int id_place) {
        this.id_place = id_place;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", gender=" + gender +
                ", birthdate=" + birthdate +
                ", imgUser=" + imgUser +
                ", last_access=" + last_access +
                ", registration_date=" + registration_date +
                ", id_travel=" + id_travel +
                ", id_note=" + id_note +
                ", id_picture=" + id_picture +
                ", id_place=" + id_place +
                '}';
    }
}
