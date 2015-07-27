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
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.sql.Date;
import java.util.ArrayList;
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

    public void setDriverDAO(DriverDAO driverDAO) {
        this.driverDAO = driverDAO;
    }

    public VehicleDAO getVehicleDAO() {
        return vehicleDAO;
    }

    public void setVehicleDAO(VehicleDAO vehicleDAO) {
        this.vehicleDAO = vehicleDAO;
    }

    public LocationDAO getLocationDAO() {
        return locationDAO;
    }

    public void setLocationDAO(LocationDAO locationDAO) {
        this.locationDAO = locationDAO;
    }

    @Override
    public DriverAvailability getDriverAvailability() {
        return null;
    }

    @Override
    @Transactional
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

    @Transactional(propagation = Propagation.REQUIRED)
    public List<DriverAvailabilityDTO> getAllDriverAvailabilities() {
        List<DriverAvailability> driverAvailabilityList = super.getAll();
        List<DriverAvailabilityDTO> driverAvailabilityDTOs = new ArrayList<>();
        for (DriverAvailability driverAvailability : driverAvailabilityList) {
            DriverAvailabilityDTO driverAvailabilityDTO = new DriverAvailabilityDTO();
            driverAvailabilityDTO.setDriverId(Integer.toString(driverAvailability.getDriver().getDriverId()));
            driverAvailabilityDTO.setVehicleId(Integer.toString(driverAvailability.getVehicle().getVehicleId()));
            driverAvailabilityDTO.setLocationId(Integer.toString(driverAvailability.getLocation().getId()));
            driverAvailabilityDTO.setDateString(driverAvailability.getDate());

            String timeSlotString = driverAvailability.getTimeSlot();
            java.util.Date fromTime = TimeSlotUtil.getFromTimeFromTimeSlotString(driverAvailability.getDate(),
                    timeSlotString);
            java.util.Date toTime = TimeSlotUtil.getToTimeFromTimeSlotString(driverAvailability.getDate(),
                    timeSlotString);
            driverAvailabilityDTO.setTimeFrom(fromTime);
            driverAvailabilityDTO.setTimeTo(toTime);
            driverAvailabilityDTOs.add(driverAvailabilityDTO);
        }
        return driverAvailabilityDTOs;
    }

}


