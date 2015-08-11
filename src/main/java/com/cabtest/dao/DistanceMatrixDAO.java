package com.cabtest.dao;

import com.cabtest.model.DistanceMatrix;
import com.cabtest.model.Location;

import java.util.Map;

public interface DistanceMatrixDAO extends GenericDAO<DistanceMatrix, Integer> {
    Map<Integer, Integer> getLocations(int originId, int maxTravelTime);
}

