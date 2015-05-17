package com.cabtest.managed.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.springframework.dao.DataAccessException;

import com.cabtest.model.Vehical;
import com.cabtest.service.VehicalRegisterService;

/**
 * 
 * Vehical Managed Bean
 * 
 * 
 *
 * 
 *
 */
@ManagedBean(name="vehicalMB")
@RequestScoped
public class CabTestManagedBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private static final String SUCCESS = "success";
	private static final String ERROR   = "error";
	
	//Spring Vehical Service is injected...
	@ManagedProperty(value="#{VehicalRegisterServiceImpl}")
	VehicalRegisterService vehicalService;
	
	List<Vehical> vehicalList;
	
	private int vid;
	private String name;
	private String type;
	private String flagv;
	/**
	 * Add Vehical
	 * 
	 * @return String - Response Message
	 */
	public String addVehical() {
		try {
			Vehical vehical = new Vehical();
			vehical.setId(getId());
			vehical.setName(getName());
			vehical.setType(getType());
			vehical.setFlagv(getFlagv());
			getVehicalService().addVehical(vehical);
			return SUCCESS;
		} catch (DataAccessException e) {
			e.printStackTrace();
		} 	
		
		return ERROR;
	}
	
	/* Delete Vehical***/
	
	
	public String deleteVehical() {
		try {
			Vehical vehical = new Vehical();
			vehical.setId(getId());
			vehical.setName(getName());
			vehical.setType(getType());
			vehical.setFlagv(getFlagv());
			getVehicalService().deleteVehical(vehical);
			return SUCCESS;
		} catch (DataAccessException e) {
			e.printStackTrace();
		} 	
		
		return ERROR;
	}
	
	/*Update vehical*/
	
	public String updateVehical() {
		try {
			Vehical vehical = new Vehical();
			vehical.setId(getId());
			vehical.setName(getName());
			vehical.setType(getType());
			vehical.setFlagv(getFlagv());
			getVehicalService().updateVehical(vehical);
			return SUCCESS;
		} catch (DataAccessException e) {
			e.printStackTrace();
		} 	
		
		return ERROR;
	}
	
	
	public String getVehicalById() {
		
		try {
			
			Vehical vehical = new Vehical();
			
			vehical = getVehicalService().getVehicalById(getId());
			
			setId(vehical.getId());
			setName(vehical.getName());
			setType(vehical.getType());
			setFlagv(vehical.getFlagv());
			
			return SUCCESS;
		
		} catch (DataAccessException e) {
			e.printStackTrace();
		} 	
		
		return ERROR;
	
	
	 }
	
	
	
	
	
	
	
	
	
	/**
	 * Reset Fields
	 * 
	 */
	public void reset() {
		this.setId(0);
		this.setName("");
		this.setType("");
	    this.setFlagv("");
	}
	
	/**
	 * Get Vehical List
	 * 
	 * @return List - Vehical List
	 */
	public List<Vehical> getVehicalList() {
		vehicalList = new ArrayList<Vehical>();
		vehicalList.addAll(getVehicalService().getVehicals());
		return vehicalList;
	}
	
	/**
	 * Get Vehical Service
	 * 
	 * @return IVehicalService - Vehical Service
	 */
	public VehicalRegisterService getVehicalService() {
		return vehicalService;
	}

	/**
	 * Set Vehical Service
	 * 
	 * @param IVehicalService - Vehical Service
	 */
	public void setVehicalService(VehicalRegisterService vehicalService) {
		this.vehicalService = vehicalService;
	}
	
	/**
	 * Set Vehical List
	 * 
	 * @param List - Vehical List
	 */
	public void setVehicalList(List<Vehical> vehicalList) {
		this.vehicalList = vehicalList;
	}
	
	/**
	 * Get Vehical Id
	 * 
	 * @return int - Vehical Id
	 */
	public int getId() {
		return vid;
	}

	/**
	 * Set Vehical Id
	 * 
	 * @param int - Vehical Id
	 */
	public void setId(int vid) {
		this.vid = vid;
	}

	/**
	 * Get Vehical Name
	 * 
	 * @return String - Vehical Name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Set Vehical Name
	 * 
	 * @param String - Vehical Name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Get Vehical Type
	 * 
	 * @return String - Vehical Type
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * Set Vehical Type
	 * 
	 * @param String - Vehical Type
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	public String getFlagv(){
		return flagv;
	}
	
	public void setFlagv(String flagv){
		this.flagv  = flagv;
	}
	
}
