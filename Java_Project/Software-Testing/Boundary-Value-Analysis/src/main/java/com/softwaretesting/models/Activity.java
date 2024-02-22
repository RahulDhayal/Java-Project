package com.softwaretesting.models;

import java.util.HashMap;


/**
 * Model class for avtivoty
 */
public class Activity {
    /**
     * Activity name
     */
    public String name;

    /**
     * Description about activity
     */
    public String description;

    /**
     * Cost per head for the activity
     */
    public double cost;

    /**
     * Capacity of the activity
     */
    public int capacity;

    /**
     * Set of enrolled passengers for the activity
     */
    public HashMap<Integer, Passenger>enrolledPassengers;

    public Activity(String name, String description, double cost, int capacity){
    this.name=name;
    this.description=description;
    this.cost=cost;
    this.capacity=capacity;
    this.enrolledPassengers = new HashMap<>();
  }

  
}
