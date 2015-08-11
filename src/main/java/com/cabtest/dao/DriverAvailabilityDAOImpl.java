package com.cabtest.dao;

import com.cabtest.model.DriverAvailability;
import com.cabtest.model.Location;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Vehical DAO
 *
 * @author onlinetechvision.com
 * @version 1.0.0
 * @since 25 Mar 2012
 */

@Repository
public class DriverAvailabilityDAOImpl extends GenericDAOImpl<DriverAvailability, Integer>
        implements DriverAvailabilityDAO {


    @Override
    public List<DriverAvailability> getAvailableDrivers(Date date, List<Location> locations) {
        List<Integer> locationIds = new ArrayList<>();
        for (Location location : locations) {
            getCurrentSession().update(location);
            locationIds.add(location.getId());
        }
        Query query = getCurrentSession().createQuery("from DriverAvailability where date = :date and location in " +
                ":location");
        query.setParameter("date", date);
        query.setParameterList("location", locations);
        return (ArrayList<DriverAvailability>) query.list();
    }
}
