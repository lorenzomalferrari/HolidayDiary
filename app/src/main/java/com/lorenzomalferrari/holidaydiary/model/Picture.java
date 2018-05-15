package com.lorenzomalferrari.holidaydiary.model;

public class Picture {

    private int id, id_user;
    private String title, description;

    public Picture() {
    }

    public Picture(int id, String title, String description, int id_user) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.id_user = id_user;
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

    @Override
    public String toString() {
        return "Picture{" +
                "id=" + id +
                ", id_user=" + id_user +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
