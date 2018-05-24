package com.lorenzomalferrari.holidaydiary.model;

import java.util.Arrays;

/**
 *
 * @author Lorenzo Malferrari - Website: www.lorenzomalferrari.com
 */
public class Picture {

  private int id, id_user, id_travel, id_place;
  private String title,description;
  private byte[] image;

    public Picture() {
    }

    public Picture(String title, byte[] image, int id_user) {
        this.id_user = id_user;
        this.title = title;
        this.image = image;
    }

    public Picture(int id, String title, String description, byte[] image, int id_user, int id_travel, int id_place) {
        this.id = id;
        this.id_user = id_user;
        this.id_travel = id_travel;
        this.id_place = id_place;
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
                ", image=" + Arrays.toString(image) +
                ", id_user=" + id_user +
                ", id_travel=" + id_travel +
                ", id_place=" + id_place +
                '}';
    }
}
