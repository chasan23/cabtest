package com.cabtest;

public class ConfigurationBuilder {

    public static float getTimeSlotSizeInMinutes() {
        return 30;
    }

    public static float getTimeSlotSizeInMilliSeconds() {
        return getTimeSlotSizeInMinutes() * 60 * 1000;
    }

    public static double getDriverChargePercentage() {
        return 20;
    }

    public static double getServiceChargePercentage() {
        return 20;
    }

    public static double getVehicleChargePercentage() {
        return 20;
    }

    public static double getDriverChargeFixed() {
        return 100;
    }

    public static double getServiceChargeFixed() {
        return 100;
    }

    public static double getVehicleChargeFixed() {
        return 300;
    }

    public static int getMonthlySettlementDate() {
        return 25;
    }

    public static int getCabServiceIdentifier() {
        return 0;
    }
}
