package com.cabtest.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cabtest.model.Vehicle;

/**
 * 
 * Vehical DAO
 * 
 * @author onlinetechvision.com
 * @since 25 Mar 2012
 * @version 1.0.0
 *
 */

@Repository
public class VehicleDAOImpl extends GenericDAOImpl<Vehicle, Integer> implements VehicleDAO {
	
	
}
