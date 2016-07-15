package com.ok.irragation.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the finishirregationinfo database table.
 * 
 */
@Entity
@NamedQuery(name="Finishirregationinfo.findAll", query="SELECT f FROM Finishirregationinfo f")
public class Finishirregationinfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int finishIrregationInfoID;

	private Timestamp dateInformation;

	private int humidity;

	private int temperature;

	public Finishirregationinfo() {
	}

	public int getFinishIrregationInfoID() {
		return this.finishIrregationInfoID;
	}

	public void setFinishIrregationInfoID(int finishIrregationInfoID) {
		this.finishIrregationInfoID = finishIrregationInfoID;
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