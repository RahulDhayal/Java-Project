package com.services;

import com.softwaretesting.models.TravelPackage;

import java.util.List;

import com.softwaretesting.models.Activity;
import com.softwaretesting.models.Destination;

public class DestinationService {
    /**
     * Adds onbords activities to existing destinations
     * @param travelPackage Travel Package
     * @param activities list of avilable activities 
     * @param command input command with params
     */
     public void addActivity(TravelPackage travelPackage, List<Activity> activities, String command){
        String[] tasks = command.split(" ");
        Activity activity = null;
        Destination destination = null;
        for(int i=0;i<activities.size();i++){
            if(tasks[2].equals(activities.get(i).name)){
                activity=activities.get(i);
            }
        }
        for(int i=0;i<travelPackage.destinations.size();i++){
            if(tasks[1].equals(travelPackage.destinations.get(i).name)){
                destination=travelPackage.destinations.get(i);
            }
        }
        boolean alreadyExist = false;
        for(int i=0;i<travelPackage.destinations.size();i++){
            Destination currentDestination = travelPackage.destinations.get(i);
            if(currentDestination.activities.containsKey(activity.name)){
                System.out.println("Activity already exist");
                alreadyExist=true;
                break;
            } 
        }
        if(!alreadyExist){
            destination.activities.put(activity.name, activity);
        }
     }
}
