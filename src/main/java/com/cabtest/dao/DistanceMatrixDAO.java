package com.cabtest.dao;

import com.cabtest.model.DistanceMatrix;

import java.util.Map;

public interface DistanceMatrixDAO extends GenericDAO<DistanceMatrix, Integer> {
    Map<Integer, Integer> getLocations(int originId, int maxTravelTime);
}

