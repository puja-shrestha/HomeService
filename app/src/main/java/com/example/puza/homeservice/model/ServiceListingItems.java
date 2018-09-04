package com.example.puza.homeservice.model;

public class ServiceListingItems {

    private int image;
    private String title;
    private String price;
    private String perhour;
    private String day;
    private String description;

    public ServiceListingItems(int image, String title, String price, String perhour, String day, String description) {
        this.image = image;
        this.title = title;
        this.price = price;
        this.perhour = perhour;
        this.day = day;
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPerhour() {
        return perhour;
    }

    public void setPerhour(String perhour) {
        this.perhour = perhour;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
