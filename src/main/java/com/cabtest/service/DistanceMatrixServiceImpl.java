package com.cabtest.service;

import com.cabtest.bean.TimeSlot;
import com.cabtest.dao.DistanceMatrixDAO;
import com.cabtest.dao.GenericDAO;
import com.cabtest.dao.LocationDAO;
import com.cabtest.dto.DistanceMatrixDTO;
import com.cabtest.model.DistanceMatrix;
import com.cabtest.model.Location;
import com.cabtest.util.TimeSlotUtil;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DistanceMatrixServiceImpl extends GenericPersistenceServiceImpl<DistanceMatrix, Integer>
        implements DistanceMatrixService {

    private DistanceMatrixDAO distanceMatrixDAO;
    private LocationDAO locationDAO;

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
    @Transactional
    public List<DistanceMatrixDTO> getDistanceMatrix() {
        List<DistanceMatrixDTO> distanceMatrixDTOList = new ArrayList<>();
        for (DistanceMatrix distanceMatrix : this.getAll()) {
            String locationAB = distanceMatrix.getLocationAB();
            String locationA = locationAB.split(":")[0];
            String locationB = locationAB.split(":")[1];
            DistanceMatrixDTO distanceMatrixDTO = new DistanceMatrixDTO(distanceMatrix);
            distanceMatrixDTO.setLocationNameA(getLocationDAO().findByKey(Integer.parseInt(locationA)));
            distanceMatrixDTO.setLocationNameB(getLocationDAO().findByKey(Integer.parseInt(locationB)));
            distanceMatrixDTOList.add(distanceMatrixDTO);
        }
        return distanceMatrixDTOList;
    }

    @Override
    @Transactional
    public Map<TimeSlot, List<Location>> getLocations(int originId, TimeSlot maxTravelTime) {
        int maxTravelTimeInMinutes = TimeSlotUtil.convertTimeSlotsToMinutes(maxTravelTime);
        Map<TimeSlot, List<Location>> locationsByTimeSlots = new HashMap<>();
        Map<Integer, Integer> locationsByTime = distanceMatrixDAO.getLocations(originId, maxTravelTimeInMinutes);
        for (Integer travelTimeMinutes : locationsByTime.keySet()) {
            TimeSlot travelTime = TimeSlotUtil.convertMinutesToTimeSlots(travelTimeMinutes, true);

            List<Location> locations = locationsByTimeSlots.get(travelTime);
            if (locations != null) {
                locations.add(locationDAO.findByKey(locationsByTime.get(travelTimeMinutes)));
            } else {
                List<Location> locationsForTravelTime = new ArrayList<>();
                locationsForTravelTime.add(locationDAO.findByKey(locationsByTime.get(travelTimeMinutes)));
                locationsByTimeSlots.put(travelTime, locationsForTravelTime);
            }
        }
        return locationsByTimeSlots;
    }

    public LocationDAO getLocationDAO() {
        return locationDAO;
    }

    public void setLocationDAO(LocationDAO locationDAO) {
        this.locationDAO = locationDAO;
    }
}



