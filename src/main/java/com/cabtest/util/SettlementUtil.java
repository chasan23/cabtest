package com.cabtest.util;

import com.cabtest.ConfigurationBuilder;

public class SettlementUtil {
    public static double getDriverCharge(double amount) {
        double driverCharge = amount * ConfigurationBuilder.getDriverChargePercentage() / 100;
        if (driverCharge > ConfigurationBuilder.getDriverChargeFixed()) {
            return driverCharge;
        } else {
            return ConfigurationBuilder.getDriverChargeFixed();
        }
    }

    public static double getVehicleCharge(double amount) {
        double vehicleCharge = amount * ConfigurationBuilder.getVehicleChargePercentage() / 100;
        if (vehicleCharge > ConfigurationBuilder.getVehicleChargeFixed()) {
            return vehicleCharge;
        } else {
            return ConfigurationBuilder.getVehicleChargeFixed();
        }
    }

    public static double getServiceCharge(double amount) {
        double serviceCharge = amount * ConfigurationBuilder.getServiceChargePercentage() / 100;
        if (serviceCharge > ConfigurationBuilder.getServiceChargeFixed()) {
            return serviceCharge;
        } else {
            return ConfigurationBuilder.getServiceChargeFixed();
        }
    }
}
