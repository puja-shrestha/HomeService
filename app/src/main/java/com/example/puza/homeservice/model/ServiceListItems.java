package com.example.puza.homeservice.model;

public class ServiceListItems {

    private int bImage;
    private String title;

    public ServiceListItems(int bImage, String title) {
        this.bImage = bImage;
        this.title = title;
    }

    public int getbImage() {
        return bImage;
    }

    public void setbImage(int bImage) {
        this.bImage = bImage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
