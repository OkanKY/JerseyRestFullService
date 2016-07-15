package com.ok.irragation.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the climate database table.
 * 
 */
@Entity
@NamedQuery(name="Climate.findAll", query="SELECT c FROM Climate c")
public class Climate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int climateID;

	private String climateInfo;

	public Climate() {
	}

	public int getClimateID() {
		return this.climateID;
	}

	public void setClimateID(int climateID) {
		this.climateID = climateID;
	}

	public String getClimateInfo() {
		return this.climateInfo;
	}

	public void setClimateInfo(String climateInfo) {
		this.climateInfo = climateInfo;
	}

}