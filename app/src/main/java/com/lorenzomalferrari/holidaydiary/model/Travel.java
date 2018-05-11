package com.lorenzomalferrari.holidaydiary.model;

public class Travel {

    private String title;
    private String Category;
    private String Description;
    private int Thumbnail;

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
        Category = category;
        Description = description;
        Thumbnail = thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getThumbnail() {
        return Thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        Thumbnail = thumbnail;
    }

    @Override
    public String toString() {
        return "Travel{" +
                "title='" + title + '\'' +
                ", Category='" + Category + '\'' +
                ", Description='" + Description + '\'' +
                ", Thumbnail=" + Thumbnail +
                '}';
    }
}
