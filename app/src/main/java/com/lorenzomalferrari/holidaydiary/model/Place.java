package com.lorenzomalferrari.holidaydiary.model;

import java.util.Date;

/**
 *
 * @author Lorenzo Malferrari - Website: www.lorenzomalferrari.com
 */
public class Place {

    private int id, id_user, id_picture, id_travel, id_note;
    private double latitude, longitude;
    private String title, description, city, country;
    private Date creation_data;

    /**
     * Costruttore di default
     * Place pre-costruita
     */
    public Place() {
        this.id = 1;
        this.latitude = 44.4938100;
        this.longitude = 11.3387500;
        this.id_user = 1;
        this.id_picture = 1;
        this.id_travel = 1;
        this.id_note = 1;
        this.title = "Bologna";
        this.description = "Posizione di Bologna";
        this.city = "Bologna";
        this.country = "Italia";
        this.creation_data = new Date();
    }

    /**
     * Costruttore parametrico
     * Richiesta dei parametri base per l'esecuzione dell'app
     * @param latitude
     * @param longitude
     * @param id_user
     */
    public Place(double latitude, double longitude, int id_user) {
        this.id_user = id_user;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /**
     * Costruttore parametrico completo
     * Richiesta di tutti i parametri per una completa creazione del place
     * @param id
     * @param title
     * @param description
     * @param latitude
     * @param longitude
     * @param city
     * @param country
     * @param creation_data
     * @param id_user
     * @param id_picture
     * @param id_travel
     * @param id_note
     */
    public Place(int id, String title, String description, double latitude, double longitude, String city, String country, Date creation_data, int id_user, int id_picture, int id_travel, int id_note) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.id_user = id_user;
        this.id_picture = id_picture;
        this.id_travel = id_travel;
        this.id_note = id_note;
        this.title = title;
        this.description = description;
        this.city = city;
        this.country = country;
        this.creation_data = creation_data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_picture() {
        return id_picture;
    }

    public void setId_picture(int id_picture) {
        this.id_picture = id_picture;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Date getCreation_data() {
        return creation_data;
    }

    public void setCreation_data(Date creation_data) {
        this.creation_data = creation_data;
    }

    @Override
    public String toString() {
        return "Place{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", creation_data=" + creation_data +
                ", id_user=" + id_user +
                ", id_picture=" + id_picture +
                ", id_travel=" + id_travel +
                ", id_note=" + id_note +
                '}';
    }
}
