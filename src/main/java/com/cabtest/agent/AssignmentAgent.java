package com.cabtest.agent;

import com.cabtest.model.Assignment;
import com.cabtest.model.Booking;
import com.cabtest.model.Driver;
import com.cabtest.model.Vehicle;
import com.cabtest.service.AssignmentService;
import com.cabtest.service.BookingRegisterService;
import com.cabtest.service.DriverRegisterService;
import com.cabtest.service.VehicleRegisterService;

import java.util.concurrent.BlockingDeque;

public class AssignmentAgent implements Runnable {
    private BlockingDeque<Booking> BookingQueue;
    private DriverRegisterService driverRegisterService;
    private BookingRegisterService bookingRegisterService;
    private VehicleRegisterService vehicleRegisterService;
    private AssignmentService assignmentService;
    @Override
    public void run() {

    }

    private void performAssignment(Booking booking) {


        Vehicle vehicle = vehicleRegisterService.getAvailableVehicle(booking.getVehicleType());
        Driver driver = driverRegisterService.getAvailableDriver();
        Assignment assignment = new Assignment();
        assignment.setDriver(driver);
        assignment.setVehicle(vehicle);
        assignmentService.save(assignment);
    }

}

