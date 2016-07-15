package com.ok.irragation.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the otherfertilizationinfo database table.
 * 
 */
@Entity
@NamedQuery(name="Otherfertilizationinfo.findAll", query="SELECT o FROM Otherfertilizationinfo o")
public class Otherfertilizationinfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int otherFert�l�zat�onInfoID;

	private Timestamp dateInformation;

	private int growthValue;

	public Otherfertilizationinfo() {
	}

	public int getOtherFert�l�zat�onInfoID() {
		return this.otherFert�l�zat�onInfoID;
	}

	public void setOtherFert�l�zat�onInfoID(int otherFert�l�zat�onInfoID) {
		this.otherFert�l�zat�onInfoID = otherFert�l�zat�onInfoID;
	}

	public Timestamp getDateInformation() {
		return this.dateInformation;
	}

	public void setDateInformation(Timestamp dateInformation) {
		this.dateInformation = dateInformation;
	}

	public int getGrowthValue() {
		return this.growthValue;
	}

	public void setGrowthValue(int growthValue) {
		this.growthValue = growthValue;
	}

}