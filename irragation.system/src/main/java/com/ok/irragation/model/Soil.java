package com.ok.irragation.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the soil database table.
 * 
 */
@Entity
@NamedQuery(name="Soil.findAll", query="SELECT s FROM Soil s")
public class Soil implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int soilID;

	private String soilInfo;

	public Soil() {
	}

	public int getSoilID() {
		return this.soilID;
	}

	public void setSoilID(int soilID) {
		this.soilID = soilID;
	}

	public String getSoilInfo() {
		return this.soilInfo;
	}

	public void setSoilInfo(String soilInfo) {
		this.soilInfo = soilInfo;
	}

}