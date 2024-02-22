package com.softwaretesting;

import org.junit.jupiter.api.Test;

import com.services.ActivityService;
import com.softwaretesting.models.Activity;
import com.softwaretesting.models.PassengerType;
import com.softwaretesting.models.TravelPackage;
import com.softwaretesting.models.Passenger;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
/**
 * Unit test cases for Tour and Travel Management
 */

public class TourAndTravelManagerTest {
    

    @Test     
    public void test_sign_up_for_activity_success() {
        /**
         * Arrange 
         */
        TravelPackage travelPackage = new TravelPackage("Test", 2);
        Activity activity = new Activity("A1", "playing cricket", 100.00, 2);
        Passenger passenger = new Passenger("Rahul", 1, PassengerType.GOLD, 1000);
        travelPackage.passengers.add(passenger);
        List<Activity> activites = new ArrayList<>();
        activites.add(activity);
        String inputCommand = "SIGN_UP_FOR_ACTIVITY Rahul A1";
        ActivityService activityService = new ActivityService();

        /**
         * Act
         */
        Activity updatedActivity = activityService.signUpForActivity(travelPackage, activites, inputCommand);
       
        /**
         * Assert
         */
        assertEquals(1, updatedActivity.enrolledPassengers.size());
        assertEquals(910, passenger.balance);
    } 

    @Test     
    public void test_sign_up_for_activity_fails() {
        /**
         * Arrange 
         */
        TravelPackage travelPackage = new TravelPackage("Test", 2);
        Activity activity = new Activity("A1", "playing cricket", 100.00, 2);
        Passenger passenger = new Passenger("Rahul", 1, PassengerType.STANDARD, 50);
        travelPackage.passengers.add(passenger);
        List<Activity> activites = new ArrayList<>();
        activites.add(activity);
        String inputCommand = "SIGN_UP_FOR_ACTIVITY Rahul A1";
        ActivityService activityService = new ActivityService();

        /**
         * Act
         */
        Activity updatedActivity = activityService.signUpForActivity(travelPackage, activites, inputCommand);
       
        /**
         * Assert
         */
        assertEquals(0, updatedActivity.enrolledPassengers.size());
        assertEquals(50, passenger.balance);
    } 
}
