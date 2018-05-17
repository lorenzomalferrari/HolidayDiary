package com.lorenzomalferrari.holidaydiary.model;

public class Travel {

    // Attributi della tabella Travels presente sul database HolidayDiary.db
    private String title;
    private String category;
    private String description;
    private int thumbnail, id_user;

    /**
     *
     */
    public Travel() {
    }

    /**
     * Costruttore parametrico
     * @param title
     * @param category
     * @param description
     * @param thumbnail
     */
    public Travel(String title, String category, String description, int thumbnail) {
        this.title = title;
        this.category = category;
        this.description = description;
        this.thumbnail = thumbnail;
    }

    public Travel(String title, String description, int id_user) {
        this.title = title;
        this.description = description;
        this.id_user = id_user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    /**
     * Rappresentazione testuale della classe Travel
     * @return riga di testo con tutti gli attributi e i rispettivi valori
     */
    @Override
    public String toString() {
        return "Travel{" +
                "title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                ", thumbnail=" + thumbnail +
                '}';
    }
}
