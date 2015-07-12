package com.cabtest.service;

import com.cabtest.bean.TimeSlot;
import com.cabtest.dao.DriverAvailabilityDAO;
import com.cabtest.dao.DriverDAO;
import com.cabtest.dao.GenericDAO;
import com.cabtest.dao.LocationDAO;
import com.cabtest.dao.VehicleDAO;
import com.cabtest.dto.DriverAvailabilityDTO;
import com.cabtest.model.Driver;
import com.cabtest.model.DriverAvailability;
import com.cabtest.model.DriverVehicle;
import com.cabtest.model.Location;
import com.cabtest.model.Vehicle;
import com.cabtest.util.TimeSlotUtil;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.sql.Date;
import java.util.List;

@Service
public class DriverAvailabilityServiceImpl extends GenericPersistenceServiceImpl<DriverAvailability, Integer>
        implements DriverAvailabilityService {

    private DriverAvailabilityDAO driverAvailabilityDAO;
    private DriverDAO driverDAO;
    private VehicleDAO vehicleDAO;
    private LocationDAO locationDAO;

    public DriverAvailabilityServiceImpl() {
        super();
    }


    public DriverAvailabilityDAO getDriverAvailabilityDAO() {
        return driverAvailabilityDAO;
    }

    @SuppressWarnings("unchecked")
    public void setDriverAvailabilityDAO(DriverAvailabilityDAO driverAvailabilityDAO) {
        super.setGenericDAO((GenericDAO) driverAvailabilityDAO);
        this.driverAvailabilityDAO = driverAvailabilityDAO;
    }

    public DriverDAO getDriverDAO() {
        return driverDAO;
    }

    public VehicleDAO getVehicleDAO() {
        return vehicleDAO;
    }

    public LocationDAO getLocationDAO() {
        return locationDAO;
    }

    @Override
    public DriverAvailability getDriverAvailability() {
        return null;
    }

    public void save(DriverAvailabilityDTO driverAvailabilityDTO) {
        DriverAvailability driverAvailability = new DriverAvailability();

        Driver driver = getDriverDAO().findByKey(Integer.parseInt(driverAvailabilityDTO.getDriverId()));
        Vehicle vehicle = getVehicleDAO().findByKey(Integer.parseInt(driverAvailabilityDTO.getVehicleId()));
        Location location = getLocationDAO().findByKey(Integer.parseInt(driverAvailabilityDTO.getLocationId()));

        driverAvailability.setDriver(driver);
        driverAvailability.setVehicle(vehicle);
        driverAvailability.setDate(new Date(driverAvailabilityDTO.getDate().getTime()));
        driverAvailability.setTimeSlot(TimeSlotUtil.getTimeSlotPeriodString(driverAvailabilityDTO.getTimeFrom(),
                                                                            driverAvailabilityDTO.getTimeTo()));
        driverAvailability.setLocation(location);

        super.save(driverAvailability);
    }

    public DriverVehicle getFirstAvailableDriver(Date date, List<Location> allowedLocations, TimeSlot statTime,
                                                 TimeSlot endTime,
                                                 String vehicleType) {
        List<DriverAvailability> driverAvailabilities = driverAvailabilityDAO.getAvailableDrivers(
                date, allowedLocations);
        for (DriverAvailability driverAvailability : driverAvailabilities) {
            String availableTimeSlotString = driverAvailability.getTimeSlot();
            BigInteger requiredTimeSlots = TimeSlotUtil.getTimeSlotPeriodBinaryValue(statTime, endTime);
            BigInteger availableTimeSlots = new BigInteger(availableTimeSlotString, 2);
            BigInteger result = availableTimeSlots.and(requiredTimeSlots);
            if (result.equals(requiredTimeSlots)) {
                return new DriverVehicle(driverAvailability.getDriver(), driverAvailability.getVehicle());
            }
        }
        return null;
    }
}


