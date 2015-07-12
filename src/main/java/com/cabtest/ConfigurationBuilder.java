package com.cabtest;

public class ConfigurationBuilder {

    public static float getTimeSlotSizeInMinutes(){
        return 30;
    }

    public static float getTimeSlotSizeInMilliSeconds() {
        return getTimeSlotSizeInMinutes() * 60 * 1000;
    }
}
