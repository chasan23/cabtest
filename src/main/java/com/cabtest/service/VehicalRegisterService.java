package com.cabtest.service;

import java.util.List;

import com.cabtest.model.Vehical;

/**
 * 
 * Vehical Service Interface
 * 
 * @author onlinetechvision.com
 * @since 25 Mar 2012
 * @version 1.0.0
 *
 */
public interface VehicalRegisterService {
	
	/**
	 * Add Vehical
	 * 
	 * @param  Vehical vehical
	 */
	public void addVehical(Vehical vehical);
	
	/**
	 * Update Vehical
	 * 
	 * @param  Vehical vehical
	 */
	public void updateVehical(Vehical vehical);

	/**
	 * Delete Vehical
	 * 
	 * @param  Vehical vehical
	 */
	public void deleteVehical(Vehical vehical);
	
	/**
	 * Get Vehical
	 * 
	 * @param  int Vehical Id
	 */
	public Vehical getVehicalById(int id);
	
	/**
	 * Get Vehical List
	 * 
	 * @return List - Vehical list
	 */
	public List<Vehical> getVehicals();
}
