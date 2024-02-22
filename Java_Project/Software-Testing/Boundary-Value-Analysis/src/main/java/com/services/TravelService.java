package com.services;
 
import com.softwaretesting.models.Passenger;
import com.softwaretesting.models.PassengerType;
import com.softwaretesting.models.Activity;
import com.softwaretesting.models.Destination;
import com.softwaretesting.models.TravelPackage;

public class TravelService {

    /**
     * Add new destination in travel package
     * @param travelPackage travel package
     * @param command input command
     */
    public void addDestination(TravelPackage travelPackage, String command) {
        if(travelPackage!=null){
            String[] tasks = command.split(" ");
            Destination destination = new Destination(tasks[1]);
            if(!travelPackage.destinations.contains(destination)){
               travelPackage.destinations.add(destination);
            }
        }
    }

    /**
     * To get all the destinations
     * @param travelPackage travel package
     */
    public void getDestination(TravelPackage travelPackage){
        if(travelPackage!=null && !travelPackage.destinations.isEmpty()){
            System.out.println("Destinations");
            for(int i=0;i<travelPackage.destinations.size();i++){
                Destination destination = travelPackage.destinations.get(i);
                System.out.println("Destination " + (i+1) + ": " + destination.name);
            }
        }
    }


    /**
     * add new passenger in travel package from input command
     * @param travelPackage travel package
     * @param command input command
     */
    public void addPassenger(TravelPackage travelPackage, String command){
        if(travelPackage.passengers.size() < travelPackage.passengerCapacity){
            String[] tasks = command.split(" ");
            Passenger passenger = new Passenger(tasks[1], Integer.parseInt(tasks[2]), PassengerType.valueOf(tasks[3]), Double.parseDouble(tasks[4]));
            travelPackage.passengers.add(passenger);
        }
    }

    /**
     * get passenger details from travel package
     * @param travelPackage travel package
     */
    public void getPassenger(TravelPackage travelPackage){
        System.out.println("Passenger Details");
        if(travelPackage!=null && !travelPackage.passengers.isEmpty()){
            for(int i=0;i<travelPackage.passengers.size();i++){
                Passenger passenger = travelPackage.passengers.get(i);
                System.out.println("Passenger" + (i+1) + " Name: " + passenger.name + " Passenger Number: " + passenger.passengerNumber + " Passenger Type: "+ passenger.passengerType + " Passenger Balance: " + passenger.balance);
            }
        }
    }

    /**
     * add new travel package fron input command
     * @param travelPackage travel package
     * @param command input command
     * @return
     */
    public TravelPackage addTravelPackage(TravelPackage travelPackage, String command){
        if(travelPackage==null){
            String[] tasks = command.split(" ");
            travelPackage = new TravelPackage(tasks[1], Integer.parseInt(tasks[2]));
        }
        return travelPackage;
    }
    
    /**
     * get detail about travel package
     * @param travelPackage travel package
     */
    public void getTravelPackage(TravelPackage travelPackage){
        if(travelPackage!=null){
            System.out.println("Package Name: " + travelPackage.name + " Passenger Capacity: "+ travelPackage.passengerCapacity);

        }
    }

    /**
     * Method for task-1
     * @param travelPackage input as travel package
     */
    public void getTask1(TravelPackage travelPackage){
        if(travelPackage!=null){
            System.out.println(" ");
            System.out.println("Package Name: " + travelPackage.name);
            System.out.println(" Destinations with activity details:");
            for(int i=0;i<travelPackage.destinations.size();i++){
                Destination destination = travelPackage.destinations.get(i);
                System.out.println("  Destination " + (i+1) + ": " + destination.name);
                destination.activities.forEach((key, value)->System.out.println("   Activity Name: " + key + ", Description: " + value.description + ", Cost: " + value.cost + ", Capacity: " + value.capacity));
            }
            System.out.println(" ");
        }
    }

    /**
     * Method for task-2
     * @param travelPackage input as travel package
     */
    public void getTask2(TravelPackage travelPackage){
        if(travelPackage!=null){
            System.out.println("Package Name: " + travelPackage.name);
            System.out.println(" Passenger Capacity: "+ travelPackage.passengerCapacity);
            System.out.println(" Number of passenger currently enrolled: " + travelPackage.passengers.size());
            if(!travelPackage.passengers.isEmpty()){
                for(int i=0;i<travelPackage.passengers.size();i++){
                    Passenger passenger = travelPackage.passengers.get(i);
                    System.out.println("  Passenger" + (i+1) + " Name: " + passenger.name + ", Passenger Number: " + passenger.passengerNumber);
                }
            }
            System.out.println(" ");
        }
    }

    /**
     * Method for task-3
     * @param travelPackage input as travel package
     */
    public void getTask3(TravelPackage travelPackage){
        if(travelPackage!=null && !travelPackage.passengers.isEmpty()){
            for(int i=0;i<travelPackage.passengers.size();i++){
                Passenger passenger = travelPackage.passengers.get(i);
                System.out.println(" Passenger" + (i+1) + " Name: " + passenger.name );
                System.out.println(" Passenger Number: " + passenger.passengerNumber);
                System.out.println(" Passenger balance: " + passenger.balance);
                for(int j=0;j<passenger.activitiesSignedUp.size();j++){
                    Activity activity = passenger.activitiesSignedUp.get(j);
                    System.out.println(" Activity" + (j+1) + ": " + activity.name );
                    Destination onBoardedDestination = getOnBoardDestination(activity, travelPackage);
                    System.out.println(" Destinatin: " + onBoardedDestination.name);
                    double cost=0;
                    if(passenger.passengerType==PassengerType.GOLD){
                        cost = activity.cost*0.9;
                    }else if(passenger.passengerType==PassengerType.PREMIUM){
                        cost=0;
                    }else{
                        cost=activity.cost;
                    }
                    System.out.println(" Cost paid for this activity by " + passenger.name +" is: " + cost);
                }
                System.out.println(" ");
            }
        }
    }

    /**
     * Method to get destination on the basis of activity
     * @param activity activity
     * @param travelPackage trvavel package
     * @return
     */
    private Destination getOnBoardDestination(Activity activity, TravelPackage travelPackage){
        for(int i=0;i<travelPackage.destinations.size();i++){
            Destination destination = travelPackage.destinations.get(i);
            if(destination.activities.containsKey(activity.name)){
                return destination;
            }
        }
        return null;
    }


}
