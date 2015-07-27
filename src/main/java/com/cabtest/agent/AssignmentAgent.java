package com.cabtest.agent;

import com.cabtest.bean.TimeSlot;
import com.cabtest.model.Assignment;
import com.cabtest.model.Booking;
import com.cabtest.model.DriverVehicle;
import com.cabtest.model.Location;
import com.cabtest.service.AssignmentService;
import com.cabtest.service.BookingRegisterService;
import com.cabtest.service.DistanceMatrixService;
import com.cabtest.service.DriverAvailabilityService;
import com.cabtest.service.DriverRegisterService;
import com.cabtest.service.VehicleRegisterService;
import com.cabtest.util.TimeSlotUtil;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingDeque;

@Component
@Scope("prototype")
public class AssignmentAgent implements Runnable {
    private BlockingDeque<Booking> bookingQueue;
    private DriverAvailabilityService driverAvailabilityService;
    private AssignmentService assignmentService;
    private DistanceMatrixService distanceMatrixService;
    private TimeSlot maxArriveTime = new TimeSlot(4);

    @Override
    public void run() {
        while (true){
            System.out.println("running task 1 ");
            try {
                System.out.println("running task 2");
                Booking booking = bookingQueue.take();
                System.out.println("running task 3");
                if(booking != null) {
                    performAssignment(booking);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    private void performAssignment(Booking booking) {

        int hireDuration = booking.getDuration();
        Timestamp hireStartTime = booking.getTime();

        TimeSlot startTime = TimeSlotUtil.convertTimeStampToTimeSlots(hireStartTime, false);

        TimeSlot duration = TimeSlotUtil.convertMinutesToTimeSlots(hireDuration, true);

        TimeSlot endTime = startTime.add(duration);

        int originId = booking.getOriginId();

        Map<TimeSlot, List<Location>> allowedDriverLocations = distanceMatrixService.getLocations(originId,
                                                                                                  maxArriveTime);
        for (TimeSlot arrivalTime : allowedDriverLocations.keySet()) {
            DriverVehicle driver = driverAvailabilityService.getFirstAvailableDriver(TimeSlotUtil.getDate
                    (hireStartTime), allowedDriverLocations.get(arrivalTime), startTime, endTime, booking.getVehicleType());

            if (driver != null) {
                Assignment assignment = new Assignment();
                assignment.setDriver(driver.getDriver());
                assignment.setVehicle(driver.getVehicle());
                assignment.setTime(new Timestamp(new Date().getTime()));
                assignmentService.save(assignment);
                break;
            }
        }
    }

    public void setBookingQueue(BlockingDeque<Booking> bookingQueue) {
        this.bookingQueue = bookingQueue;
    }

    public void setDistanceMatrixService(DistanceMatrixService distanceMatrixService) {
        this.distanceMatrixService = distanceMatrixService;
    }

    public void setDriverAvailabilityService(DriverAvailabilityService driverAvailabilityService) {
        this.driverAvailabilityService = driverAvailabilityService;
    }

    public void setAssignmentService(AssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }
}

