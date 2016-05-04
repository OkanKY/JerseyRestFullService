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
	private int otherFertýlýzatýonInfoID;

	private Timestamp dateInformation;

	private int growthValue;

	public Otherfertilizationinfo() {
	}

	public int getOtherFertýlýzatýonInfoID() {
		return this.otherFertýlýzatýonInfoID;
	}

	public void setOtherFertýlýzatýonInfoID(int otherFertýlýzatýonInfoID) {
		this.otherFertýlýzatýonInfoID = otherFertýlýzatýonInfoID;
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