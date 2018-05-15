package com.lorenzomalferrari.holidaydiary.model;

public class Travel {

    // Attributi della tabella Travels presente sul database holidayDiary.db
    private String title;
    private String category;
    private String description;
    private int thumbnail;

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
