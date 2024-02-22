
package com.softwaretesting;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import com.services.ActivityService;
import com.services.DestinationService;
import com.services.TravelService;
import com.softwaretesting.models.TravelPackage;
import com.softwaretesting.models.Activity;;

public class TourAndTravelManager {
  public static void main(String[] args){

        TravelPackage travelPackage = null;
        List<Activity> activities = new ArrayList<>();
        ActivityService activityService = new ActivityService();
        DestinationService destinationService = new DestinationService();
        TravelService travelService = new TravelService();

        List<String> records = new ArrayList<String>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\Rahul Choudhary\\OneDrive\\Desktop\\Nymble_Task\\input.txt"), StandardCharsets.UTF_8))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().length() == 0) continue;
                records.add(line);          
            }
        } catch (Exception e) {
            System.out.println("Unable to read the file" + e.getMessage());
            System.exit(0);
        }

        for (String inputString : records) {
            String task = inputString.split(" ")[0];
            switch (task) {
                case "ADD_TRAVELPACKAGE":
                    travelPackage=travelService.addTravelPackage(travelPackage, inputString);
                    break;
                case "GET_TRAVELPACKAGE":
                    travelService.getTravelPackage(travelPackage);
                    break;
                case "ADD_DESTINATION":
                    travelService.addDestination(travelPackage, inputString);
                    break;
                case "GET_DESTINATION":
                    travelService.getDestination(travelPackage);
                    break;
                case "ADD_PASSENGER":
                    travelService.addPassenger(travelPackage,inputString);
                    break;
                case "GET_PASSENGER":
                    travelService.getPassenger(travelPackage);
                    break;
                case "ADD_ACTIVITY":
                    activityService.addActivity(activities, inputString);
                    break;
                case "ON_BOARD_ACTIVITY_TO_DESTINATION":
                    destinationService.addActivity(travelPackage, activities, inputString);
                    break;
                case "SIGN_UP_FOR_ACTIVITY":
                    activityService.signUpForActivity(travelPackage, activities, inputString);
                    break;
                case "GET_TASK_1":
                    travelService.getTask1(travelPackage);
                    break;
                case "GET_TASK_2":
                    travelService.getTask2(travelPackage);
                    break;
                    case "GET_TASK_3":
                    travelService.getTask3(travelPackage);
                    break;
                    case "GET_TASK_4":
                    activityService.getTask4(activities);
                    break;
                default:
                    System.out.println("Invalid Input");
                    break;
            }
        }
    
  }

  
}





