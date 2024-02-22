package com.softwaretesting.models;

import java.util.ArrayList;
import java.util.List;


/**
 * Model class for Travel Package
 */
public class TravelPackage {
    /**
     * Travel Pakage name
     */
    public String name;

    /**
     * Capapcity of this package
     */
    public int passengerCapacity;

    /**
     * List of all the destination of the package
     */
    public List<Destination>destinations;

    /**
     * List of all the the psssengers of this package
     */
    public List<Passenger> passengers;

    public TravelPackage(String name, int passengerCapacity){
        this.name=name;
        this.passengerCapacity=passengerCapacity;
        this.destinations = new ArrayList<>();
        this.passengers = new ArrayList<>();
    }

    
}
