package com.ok.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the otherirregationinfo database table.
 * 
 */
@Entity
@NamedQuery(name="Otherirregationinfo.findAll", query="SELECT o FROM Otherirregationinfo o")
public class Otherirregationinfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int otherIrregationInfoID;

	private int avarageHumidity;

	private int avarageTemperature;

	private Timestamp dateInformation;

	private int growthValue;

	private int limitValueOutHumidity;

	private int limitValueOutTemperature;

	public Otherirregationinfo() {
	}

	public int getOtherIrregationInfoID() {
		return this.otherIrregationInfoID;
	}

	public void setOtherIrregationInfoID(int otherIrregationInfoID) {
		this.otherIrregationInfoID = otherIrregationInfoID;
	}

	public int getAvarageHumidity() {
		return this.avarageHumidity;
	}

	public void setAvarageHumidity(int avarageHumidity) {
		this.avarageHumidity = avarageHumidity;
	}

	public int getAvarageTemperature() {
		return this.avarageTemperature;
	}

	public void setAvarageTemperature(int avarageTemperature) {
		this.avarageTemperature = avarageTemperature;
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

	public int getLimitValueOutHumidity() {
		return this.limitValueOutHumidity;
	}

	public void setLimitValueOutHumidity(int limitValueOutHumidity) {
		this.limitValueOutHumidity = limitValueOutHumidity;
	}

	public int getLimitValueOutTemperature() {
		return this.limitValueOutTemperature;
	}

	public void setLimitValueOutTemperature(int limitValueOutTemperature) {
		this.limitValueOutTemperature = limitValueOutTemperature;
	}

}