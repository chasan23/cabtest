package com.cabtest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * Vehical Entity
 * 
 * @author onlinetechvision.com
 * @since 25 Mar 2012
 * @version 1.0.0
 *
 */
@Entity
@Table(name="vehicle")
public class Vehical {

	private int vid;
	private String name;
	private String type;
	private String flagv;
	/**
	 * Get Vehical Id
	 * 
	 * @return int - Vehical Id
	 */
	@Id
	@Column(name="vid", unique = true, nullable = false)
	public int getId() {
		return vid;
	}
	
	/**
	 * Set Vehical Id
	 * 
	 * @param int - Vehical Id
	 */
	public void setId(int vid) {
		this.vid =vid;
	}
	
	/**
	 * Get Vehical Name
	 * 
	 * @return String - Vehical Name
	 */
	@Column(name="name", unique = true, nullable = false)
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
	@Column(name="type", unique = true, nullable = false)
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
	
	
	
	
	/**
	 * Get flagv
	 * 
	 * @return String flagv
	 */
	@Column(name="flagv", unique = true, nullable = false)
	public String getFlagv() {
		return flagv;
	}
	
	/**
	 * Set flagv
	 * 
	 * @param String - flagv
	 */
	public void setFlagv(String flagv) {
		this.flagv = flagv;
	}
	
	
	
	@Override
	public String toString() {
		StringBuffer strBuff = new StringBuffer();
		strBuff.append("id : ").append(getId());
		strBuff.append(", name : ").append(getName());
		strBuff.append(", type : ").append(getType());
		strBuff.append(", flagv : ").append(getFlagv());
		return strBuff.toString();
	}
}
