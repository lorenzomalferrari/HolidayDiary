package com.lorenzomalferrari.holidaydiary.model;

import java.util.Date;

/**
 *
 * @author Lorenzo Malferrari - Website: www.lorenzomalferrari.com
 */
public class Note {

    private int id, id_user, id_travel, id_place, id_picture;
    private String title, description;
    private Date creation_data;


    /**
     * Costruttore di default
     * Nota pre-costruita
     */
    public Note() {
        this.id = 1;
        this.id_user = 1;
        this.id_travel = 1;
        this.id_place = 1;
        this.id_picture = 1;
        this.title = "Nota 1";
        this.description = "Questo è il testo della nota n° 1";
        this.creation_data = new Date();
    }

    /**
     * Costruttore parametrico
     * Richiesta dei parametri base per l'esecuzione dell'app
     * @param title
     * @param creation_data
     * @param description
     * @param id_user
     */
    public Note(String title, Date creation_data, String description,int id_user) {
        this.id_user = id_user;
        this.title = title;
        this.description = description;
        this.creation_data = creation_data;
    }

    /**
     * Costruttore parametrico completo
     * Richiesta di tutti i parametri per una completa creazione della nota
     * @param id
     * @param title
     * @param description
     * @param creation_data
     * @param id_user
     * @param id_travel
     * @param id_place
     * @param id_picture
     */
    public Note(int id, String title, String description, Date creation_data, int id_user, int id_travel, int id_place, int id_picture) {
        this.id = id;
        this.id_user = id_user;
        this.id_travel = id_travel;
        this.id_place = id_place;
        this.id_picture = id_picture;
        this.title = title;
        this.description = description;
        this.creation_data = creation_data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_travel() {
        return id_travel;
    }

    public void setId_travel(int id_travel) {
        this.id_travel = id_travel;
    }

    public int getId_place() {
        return id_place;
    }

    public void setId_place(int id_place) {
        this.id_place = id_place;
    }

    public int getId_picture() {
        return id_picture;
    }

    public void setId_picture(int id_picture) {
        this.id_picture = id_picture;
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

    public Date getCreation_data() {
        return creation_data;
    }

    public void setCreation_data(Date creation_data) {
        this.creation_data = creation_data;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", creation_data=" + creation_data +
                ", id_user=" + id_user +
                ", id_travel=" + id_travel +
                ", id_place=" + id_place +
                ", id_picture=" + id_picture +
                '}';
    }
}
