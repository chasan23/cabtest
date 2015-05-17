package com.cabtest.dao;

import java.util.List;

import com.cabtest.model.Vehical;

import org.hibernate.SessionFactory;

/**
 * 
 * Vehical DAO
 * 
 * @author onlinetechvision.com
 * @since 25 Mar 2012
 * @version 1.0.0
 *
 */

public class VehicalDAOImpl implements VehicalDAO {
	
	private SessionFactory sessionFactory;

	/**
	 * Get Hibernate Session Factory
	 * 
	 * @return SessionFactory - Hibernate Session Factory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * Set Hibernate Session Factory
	 * 
	 * @param SessionFactory - Hibernate Session Factory
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

	/**
	 * Add Vehical
	 * 
	 * @param  Vehical vehical
	 */
	@Override
	public void addVehical(Vehical vehical) {
		getSessionFactory().getCurrentSession().save(vehical);
	}

	/**
	 * Delete Vehical
	 * 
	 * @param  Vehical vehical
	 */
	@Override
	public void deleteVehical(Vehical vehical) {
		getSessionFactory().getCurrentSession().delete(vehical);
	}

	/**
	 * Update Vehical
	 * 
	 * @param  Vehical vehical
	 */
	@Override
	public void updateVehical(Vehical vehical) {
		getSessionFactory().getCurrentSession().update(vehical);
	}

	/**
	 * Get Vehical
	 * 
	 * @param  int Vehical Id
	 * @return Vehical 
	 */
	@Override
	public Vehical getVehicalById(int id) {
		List list = getSessionFactory().getCurrentSession()
											.createQuery("from Vehical where id=?")
									        .setParameter(0, id).list();
		return (Vehical)list.get(0);
	}

	/**
	 * Get Vehical List
	 * 
	 * @return List - Vehical list
	 */
	@Override
	public List<Vehical> getVehicals() {
		List list = getSessionFactory().getCurrentSession().createQuery("from Vehical").list();
		return list;
	}

}
