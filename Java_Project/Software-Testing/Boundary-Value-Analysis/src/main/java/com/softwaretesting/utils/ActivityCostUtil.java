package com.softwaretesting.utils;

import com.softwaretesting.models.Passenger;

public final class ActivityCostUtil {
    private ActivityCostUtil() {}
    public static double getActivityCostForPassenger(Passenger passenger){
        return passenger.passengerNumber;
    }
}
