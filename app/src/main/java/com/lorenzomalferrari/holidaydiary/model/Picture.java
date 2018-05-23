package com.lorenzomalferrari.holidaydiary.model;

/**
 *
 * @author Lorenzo Malferrari - Website: www.lorenzomalferrari.com
 */
public class Picture {

    private int id, id_user, id_travel, id_place, id_note;
    private String title, description;
    private byte[] image;

    /**
     * Costruttore di default
     * Picture pre-costruita
     */
    public Picture() {
        this.id = 1;
        this.id_user = 1;
        this.id_travel = 1;
        this.id_place = 1;
        this.id_note = 1;
        this.title = "Immagine CIAO";
        this.description = "Questa è la descrizione della immagine di test";
    }

    /**
     * Costruttore parametrico
     * Richiesta dei parametri base per l'esecuzione dell'app
     * @param title
     * @param image
     * @param id_user
     */
    public Picture(String title, int id_user) {
        this.id_user = id_user;
        this.title = title;
        //this.image = image;

    }

    /**
     * Richiesta di tutti i parametri per una completa creazione della picture
     * @param id
     * @param id_user
     * @param id_travel
     * @param id_place
     * @param id_note
     * @param title
     * @param description
     * @param image
     */
    public Picture(int id, String title, String description, byte[] image, int id_user, int id_travel, int id_place, int id_note) {
        this.id = id;
        this.id_user = id_user;
        this.id_travel = id_travel;
        this.id_place = id_place;
        this.id_note = id_note;
        this.title = title;
        this.description = description;
        this.image = image;
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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Picture{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", id_user=" + id_user +
                ", id_travel=" + id_travel +
                ", id_place=" + id_place +
                ", id_note=" + id_note +
                '}';
    }
}
