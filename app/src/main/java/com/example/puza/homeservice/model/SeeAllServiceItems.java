package com.example.puza.homeservice.model;

public class SeeAllServiceItems {

    private int seeAllServicesImage;
    private String seeAllServicesTitle;
    private String seeAllServicesSubtitle;
    private String seeAllServicesButton;

    private String viewDetails;

    public SeeAllServiceItems(int seeAllServicesImage, String seeAllServicesTitle, String seeAllServicesSubtitle, String seeAllServicesButton, String viewDetails) {
        this.seeAllServicesImage = seeAllServicesImage;
        this.seeAllServicesTitle = seeAllServicesTitle;
        this.seeAllServicesSubtitle = seeAllServicesSubtitle;
        this.seeAllServicesButton = seeAllServicesButton;
        this.viewDetails = viewDetails;
    }

    public int getSeeAllServicesImage() {
        return seeAllServicesImage;
    }

    public void setSeeAllServicesImage(int seeAllServicesImage) {
        this.seeAllServicesImage = seeAllServicesImage;
    }

    public String getSeeAllServicesTitle() {
        return seeAllServicesTitle;
    }

    public void setSeeAllServicesTitle(String seeAllServicesTitle) {
        this.seeAllServicesTitle = seeAllServicesTitle;
    }

    public String getSeeAllServicesSubtitle() {
        return seeAllServicesSubtitle;
    }

    public void setSeeAllServicesSubtitle(String seeAllServicesSubtitle) {
        this.seeAllServicesSubtitle = seeAllServicesSubtitle;
    }

    public String getSeeAllServicesButton() {
        return seeAllServicesButton;
    }

    public void setSeeAllServicesButton(String seeAllServicesButton) {
        this.seeAllServicesButton = seeAllServicesButton;
    }

    public String getViewDetails() {
        return viewDetails;
    }

    public void setViewDetails(String viewDetails) {
        this.viewDetails = viewDetails;
    }
}
