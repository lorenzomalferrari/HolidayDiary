package com.lorenzomalferrari.holidaydiary.model;

import java.util.Date;

/**
 *
 * @author Lorenzo Malferrari - www.lorenzomalferrari.com
 */
public class User {

    /**
     * Variabili che rappresentano i ccampi della tabella Users
     */
    private int id, age;
    private String firstName, lastName, username, password, email, city, country;
    private char gender;
    private Date birthdate, registration_date, last_login;

    /**
     * Costruttore di default
     * (Usato per i test)
     */
    public User() {
        this.id = 0;
        this.firstName = "Lorenzo";
        this.lastName = "Malferrari";
        this.username = "malfe.lore";
        this.password = "123456";
        this.email = "malfe.lore@gmail.com";
    }


    /**
     * Costrutore base
     * Usato al momento del login
     * @param email
     * @param password
     */
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    /**
     * Costruttore completo
     * @param id
     * @param firstName
     * @param lastName
     * @param username
     * @param password
     * @param email
     * @param city
     * @param country
     * @param gender
     * @param age
     * @param birthdate
     * @param registration_date
     * @param last_login
     */
    public User(int id, String firstName, String lastName, String username, String password, String email, String city, String country, char gender,int age, Date birthdate, Date registration_date, Date last_login) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.city = city;
        this.country = country;
        this.gender = gender;
        this.age = age;
        this.birthdate = birthdate;
        this.registration_date = registration_date;
        this.last_login = last_login;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Date getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(Date registration_date) {
        this.registration_date = registration_date;
    }

    public Date getLast_login() {
        return last_login;
    }

    public void setLast_login(Date last_login) {
        this.last_login = last_login;
    }

    /**
     * Rappresentazione testuale della classe User
     * @return riga di testo con tutti gli attributi e i rispettivi valori
     */
    @Override
    public String toString() {
        return "User{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", username=" + username + ", password=" + password + ", email=" + email + ", city=" + city + ", country=" + country + ", gender=" + gender + ", age=" + age + ", birthdate=" + birthdate + ", registration_date=" + registration_date + ", last_login=" + last_login + '}';
    }

}
