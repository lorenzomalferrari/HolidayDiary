package com.lorenzomalferrari.holidaydiary.model;

import java.util.Date;

public class Note {

    private int id;
    private String title;
    private String content;
    private Date creation_date;
    private int id_user, id_travel, id_place, id_picture;

    /**
     * Costruttore di default
     */
    public Note() {
        this.id = 1;
        this.title = "Nota 1";
        this.content = "Questo è il testo della prima nota";
        this.creation_date = new Date();
        this.id_user = 1;
        this.id_travel = 1;
        this.id_picture = 1;
        this.id_place = 1;
    }

    /**
     * Costruttore parametrico
     * Inizializza l'oggetto con i parametri passati
     * @param id
     * @param title
     * @param content
     * @param creation_date
     * @param id_user
     * @param id_travel
     * @param id_place
     * @param id_picture
     */
    public Note(int id, String title, String content, Date creation_date, int id_user, int id_travel, int id_picture, int id_place) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.creation_date = creation_date;
        this.id_user = id_user;
        this.id_travel = id_travel;
        this.id_picture = id_picture;
        this.id_place = id_place;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
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

    /**
     * Rappresentazione testuale della classe Note
     * @return riga di testo con tutti gli attributi e i rispettivi valori
     */
    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", creation_date=" + creation_date +
                ", id_user=" + id_user +
                ", id_travel=" + id_travel +
                ", id_place=" + id_place +
                ", id_picture=" + id_picture +
                '}';
    }
}
