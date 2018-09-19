package com.example.puza.homeservice.model;

public class AddedServiceItems {

    private String addedServicesTitle;
    private String addedServicesSubTitle;

    public AddedServiceItems(String addedServicesTitle, String addedServicesSubTitle) {
        this.addedServicesTitle = addedServicesTitle;
        this.addedServicesSubTitle = addedServicesSubTitle;
    }

    public String getAddedServicesTitle() {
        return addedServicesTitle;
    }

    public void setAddedServicesTitle(String addedServicesTitle) {
        this.addedServicesTitle = addedServicesTitle;
    }

    public String getAddedServicesSubTitle() {
        return addedServicesSubTitle;
    }

    public void setAddedServicesSubTitle(String addedServicesSubTitle) {
        this.addedServicesSubTitle = addedServicesSubTitle;
    }
}
