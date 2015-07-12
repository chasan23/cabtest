package com.cabtest.service;

import com.cabtest.bean.TimeSlot;
import com.cabtest.model.DistanceMatrix;
import com.cabtest.model.Location;

import java.util.List;
import java.util.Map;

public interface DistanceMatrixService extends GenericPersistenceService<DistanceMatrix, Integer> {
    DistanceMatrix getDistanceMatrix();

    Map<TimeSlot, List<Location>> getLocations(int originId, TimeSlot travelTime);
}
