package com.cabtest.service;

import com.cabtest.bean.TimeSlot;
import com.cabtest.dao.DistanceMatrixDAO;
import com.cabtest.dao.GenericDAO;
import com.cabtest.model.DistanceMatrix;
import com.cabtest.model.Location;
import com.cabtest.util.TimeSlotUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DistanceMatrixServiceImpl extends GenericPersistenceServiceImpl<DistanceMatrix, Integer>
        implements DistanceMatrixService {

    private DistanceMatrixDAO distanceMatrixDAO;


    public DistanceMatrixServiceImpl() {
        super();
    }


    public DistanceMatrixDAO getDistanceMatrixDAO() {
        return distanceMatrixDAO;
    }

    @SuppressWarnings("unchecked")
    public void setDistanceMatrixDAO(DistanceMatrixDAO distanceMatrixDAO) {
        super.setGenericDAO((GenericDAO) distanceMatrixDAO);
        this.distanceMatrixDAO = distanceMatrixDAO;
    }

    @Override
    public DistanceMatrix getDistanceMatrix() {
        return null;
    }

    @Override
    public Map<TimeSlot, List<Location>> getLocations(int originId, TimeSlot maxTravelTime) {
        int maxTravelTimeInMinutes = TimeSlotUtil.convertTimeSlotsToMinutes(maxTravelTime);
        Map<TimeSlot, List<Location>> locationsByTimeSlots = new HashMap<>();
        Map<Integer, Location> locationsByTime = distanceMatrixDAO.getLocations(originId, maxTravelTimeInMinutes);
        for (Integer travelTimeMinutes : locationsByTime.keySet()) {
            TimeSlot travelTime = TimeSlotUtil.convertMinutesToTimeSlots(travelTimeMinutes, true);

            List<Location> locations = locationsByTimeSlots.get(travelTime);
            if(locations != null) {
                locations.add(locationsByTime.get(travelTimeMinutes));
            } else {
                List<Location> locationsForTravelTime = new ArrayList<>();
                locationsForTravelTime.add(locationsByTime.get(travelTimeMinutes));
                locationsByTimeSlots.put(travelTime, locationsForTravelTime);
            }
        }
        return locationsByTimeSlots;
    }
}



