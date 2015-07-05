package com.cabtest.service;

import com.cabtest.model.DistanceMatrix;

public interface DistanceMatrixService extends GenericPersistenceService<DistanceMatrix, Integer> {
    DistanceMatrix getDistanceMatrix ();
}
