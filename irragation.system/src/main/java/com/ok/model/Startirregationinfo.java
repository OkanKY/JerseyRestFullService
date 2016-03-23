package com.ok.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the startirregationinfo database table.
 * 
 */
@Entity
@NamedQuery(name="Startirregationinfo.findAll", query="SELECT s FROM Startirregationinfo s")
public class Startirregationinfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int startIrregationInfoID;

	private Timestamp dateInformation;

	private int humidity;

	private int temperature;

	public Startirregationinfo() {
	}

	public int getStartIrregationInfoID() {
		return this.startIrregationInfoID;
	}

	public void setStartIrregationInfoID(int startIrregationInfoID) {
		this.startIrregationInfoID = startIrregationInfoID;
	}

	public Timestamp getDateInformation() {
		return this.dateInformation;
	}

	public void setDateInformation(Timestamp dateInformation) {
		this.dateInformation = dateInformation;
	}

	public int getHumidity() {
		return this.humidity;
	}

	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}

	public int getTemperature() {
		return this.temperature;
	}

	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}

}