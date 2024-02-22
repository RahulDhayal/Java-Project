package com.services;

import java.util.List;

import com.softwaretesting.models.Activity;
import com.softwaretesting.models.Passenger;
import com.softwaretesting.models.PassengerType;
import com.softwaretesting.models.TravelPackage;

public class ActivityService {
    /**
     * Check if there is available space to add passenger in the activity
     * @param activity 
     * @return
     */
    private boolean isSpaceAvailabe(Activity activity){
        return activity.enrolledPassengers.size()<activity.capacity;
    }

    /**
     * Signup passenger for the availabe activities
     * @param travelPackage Travel package 
     * @param activities list of available activities
     * @param command input command
     * @return
     */
    public Activity signUpForActivity(TravelPackage travelPackage, List<Activity> activities, String command) {
        String[] tasks = command.split(" ");
        Activity activity = null;
        Passenger passenger = null;
        for(int i=0;i<activities.size();i++){
            if(tasks[2].equals(activities.get(i).name)){
                activity=activities.get(i);
            }
        }
        for(int i=0;i<travelPackage.passengers.size();i++){
            if(tasks[1].equals(travelPackage.passengers.get(i).name)){
                passenger=travelPackage.passengers.get(i);
            }
        }
        if(isSpaceAvailabe(activity)){
            double cost=0;
            if(passenger.passengerType==PassengerType.GOLD){
                cost = activity.cost*0.9;
            }else if(passenger.passengerType==PassengerType.PREMIUM){
                cost=0;
            }else{
                cost=activity.cost;
            }
            if(passenger.balance>=cost){
                passenger.balance-=cost;
                activity.enrolledPassengers.put(passenger.passengerNumber, passenger);
                passenger.activitiesSignedUp.add(activity);
            }else{
               System.out.println("Insufficient balance"); 
            }
        } else{
            System.out.println("Failed to add passenger space not available");
        }       
        return activity;   
    }

    /**
     * Add new avtivity in list of activities from input command
     * @param activities list of activities
     * @param command imput command
     * @return
     */
    public List<Activity> addActivity(List<Activity> activities, String command){
        String[] tasks = command.split(" ");
        Activity activity = new Activity(tasks[1], tasks[2], Double.parseDouble(tasks[3]),Integer.parseInt(tasks[4]));
        activities.add(activity);
        return activities;
    }


    /**
     * details of all the activities that still have spaces available, including how many spaces are available
     * @param activities list of activities
     */
    public void getTask4(List<Activity> activities){
        System.out.println("Activities which have still space available: ");
        for(int i=0;i<activities.size();i++){
            Activity activity = activities.get(i);
            if(activity.enrolledPassengers.size()<activity.capacity){
                int spaceAvailabe = activity.capacity-activity.enrolledPassengers.size();
                System.out.println("Activity: " + activity.name + ", Description: " + activity.description + ", Cost: " + activity.cost + ", Capacity: " + activity.capacity + ", Space available: " + spaceAvailabe);
            }
        }
    }
}
