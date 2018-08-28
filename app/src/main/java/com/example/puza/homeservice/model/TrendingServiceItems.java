package com.example.puza.homeservice.model;

public class TrendingServiceItems {

    private int Image;
    private String title;
    private String subtitle;
    private String price;

    public TrendingServiceItems(int image, String title, String subtitle, String price) {
        Image = image;
        this.title = title;
        this.subtitle = subtitle;
        this.price = price;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
