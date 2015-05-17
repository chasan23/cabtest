package com.cabtest.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.cabtest.model.Vehical;
import com.cabtest.dao.VehicalDAO;

/**
 * 
 * Vehical Service
 * 
 * @author onlinetechvision.com
 * @since 25 Mar 2012
 * @version 1.0.0
 *
 */
@Transactional(readOnly = true)
public class VehicalRegisterServiceImpl implements VehicalRegisterService {

	// VehicalDAO is injected...
	VehicalDAO vehicalDAO;
	
	/**
	 * Add Vehical
	 * 
	 * @param  Vehical vehical
	 */
	@Transactional(readOnly = false)
	@Override
	public void addVehical(Vehical vehical) {
		//process vehical
		//find age
		
		getVehicalDAO().addVehical(vehical);
	}

	/**
	 * Delete Vehical
	 * 
	 * @param  Vehical vehical
	 */
	@Transactional(readOnly = false)
	@Override
	public void deleteVehical(Vehical vehical) {
		getVehicalDAO().deleteVehical(vehical);
	}
	
	/**
	 * Update Vehical
	 * 
	 * @param  Vehical vehical
	 */
	@Transactional(readOnly = false)
	@Override
	public void updateVehical(Vehical vehical) {
		getVehicalDAO().updateVehical(vehical);
	}
	
	/**
	 * Get Vehical
	 * 
	 * @param  int Vehical Id
	 */
	@Override
	public Vehical getVehicalById(int id) {
		return getVehicalDAO().getVehicalById(id);
	}

	/**
	 * Get Vehical List
	 * 
	 */
	@Override
	public List<Vehical> getVehicals() {	
		return getVehicalDAO().getVehicals();
	}

	/**
	 * Get Vehical DAO
	 * 
	 * @return IVehicalDAO - Vehical DAO
	 */
	public VehicalDAO getVehicalDAO() {
		return vehicalDAO;
	}

	/**
	 * Set Vehical DAO
	 * 
	 * @param VehicalDAO - Vehical DAO
	 */
	public void setVehicalDAO(VehicalDAO vehicalDAO) {
		this.vehicalDAO = vehicalDAO;
	}

}

