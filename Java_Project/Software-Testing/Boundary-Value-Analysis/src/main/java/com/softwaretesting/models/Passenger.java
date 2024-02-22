package com.softwaretesting.models;

import java.util.List;
import java.util.ArrayList;
/**
 * Model class for passenger
 */
public class Passenger {
    /**
     * Passenger name
     */
    public String name;

    /**
     * Unique ID for Passenger
     */
    public int passengerNumber;

    /**
     * Passenger type like GOLD, STANDARD, etc
     */
    public PassengerType passengerType;

    /**
     * Available balance for the Passenger 
     */
    public double balance;

    /**
     * SignedUp activites by the Passenger
     */
    public List<Activity> activitiesSignedUp;

    public Passenger(String name, int passengerNumber, PassengerType passengerType, double balance){
        this.name=name;
        this.passengerNumber=passengerNumber;
        this.passengerType=passengerType;
        this.balance=balance;
        this.activitiesSignedUp = new ArrayList<>();
    }

   


}
