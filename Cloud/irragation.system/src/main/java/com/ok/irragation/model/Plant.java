package com.ok.irragation.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the plant database table.
 * 
 */
@Entity
@NamedQuery(name="Plant.findAll", query="SELECT p FROM Plant p")
public class Plant implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int plantID;

	private String plantInfo;

	public Plant() {
	}

	public int getPlantID() {
		return this.plantID;
	}

	public void setPlantID(int plantID) {
		this.plantID = plantID;
	}

	public String getPlantInfo() {
		return this.plantInfo;
	}

	public void setPlantInfo(String plantInfo) {
		this.plantInfo = plantInfo;
	}

}