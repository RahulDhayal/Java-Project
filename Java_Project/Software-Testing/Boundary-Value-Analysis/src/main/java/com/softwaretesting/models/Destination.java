package com.softwaretesting.models;

import java.util.HashMap;


/**
 * Model class for the Destination
 */
public class Destination {
    /**
     * Destination name
     */
    public String name;

    /**
     * Mapping of activites with there destinations
     */
    public HashMap<String,Activity> activities;

    public Destination(String name){
        this.name=name;
        this.activities = new HashMap<>();
    }
}
