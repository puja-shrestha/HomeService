package com.example.puza.homeservice.model;

import java.util.ArrayList;

public class ExpandableList {

    //PROPERTIES OF A SINGLE TEAM
    public String Name;
    public String Image;
    public ArrayList<String> players=new ArrayList<String>();

    public ExpandableList(String Name)
    {
        this.Name=Name;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return Name;
    }
}
