package com.example.puza.homeservice.model;

public class AllServiceItems {

    private int allServicesImage;
    private String allServicesTitle;

    public AllServiceItems(int allServicesImage, String allServicesTitle) {
        this.allServicesImage = allServicesImage;
        this.allServicesTitle = allServicesTitle;
    }

    public int getAllServicesImage() {
        return allServicesImage;
    }

    public void setAllServicesImage(int allServicesImage) {
        this.allServicesImage = allServicesImage;
    }

    public String getAllServicesTitle() {
        return allServicesTitle;
    }

    public void setAllServicesTitle(String allServicesTitle) {
        this.allServicesTitle = allServicesTitle;
    }
}
