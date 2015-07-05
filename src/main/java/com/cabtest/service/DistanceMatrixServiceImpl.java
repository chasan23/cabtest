package com.cabtest.service;

import com.cabtest.dao.GenericDAO;
import com.cabtest.dao.DistanceMatrixDAO;
import com.cabtest.model.DistanceMatrix;
import com.cabtest.model.Vehicle;
import org.springframework.stereotype.Service;

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
}



