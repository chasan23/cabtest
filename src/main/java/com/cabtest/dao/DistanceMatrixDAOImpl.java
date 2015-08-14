package com.cabtest.dao;

import com.cabtest.model.DistanceMatrix;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Vehical DAO
 *
 * @author onlinetechvision.com
 * @version 1.0.0
 * @since 25 Mar 2012
 */

@Repository
public class DistanceMatrixDAOImpl extends GenericDAOImpl<DistanceMatrix, Integer> implements DistanceMatrixDAO {

    private LocationDAO locationDAO;

    @Override
    public Map<Integer, Integer> getLocations(int originId, int maxTravelTime) {
        Query query = getCurrentSession().createQuery("from DistanceMatrix where time <= :maxTravelTime and ( " +
                "locationAB LIKE :locationABId)");

        query.setParameter("maxTravelTime", maxTravelTime);
        query.setParameter("locationABId", "%:" + originId + "%");
        List<DistanceMatrix> locations = (ArrayList<DistanceMatrix>) query.list();
        Map<Integer, Integer> locationByTime = new HashMap<>();
        for (DistanceMatrix location : locations) {
            String locationAB = location.getLocationAB();
            int locationAId = Integer.parseInt(locationAB.split(":")[0]);
            locationByTime.put(location.getTime(), locationAId);
        }
        return locationByTime;
    }

    public LocationDAO getLocationDAO() {
        return locationDAO;
    }

    public void setLocationDAO(LocationDAO locationDAO) {
        this.locationDAO = locationDAO;
    }
}
