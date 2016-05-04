package com.ok.irragation.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the field database table.
 * 
 */
@Entity
@NamedQuery(name="Field.findAll", query="SELECT f FROM Field f")
public class Field implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int fieldID;

	private int addressID;

	@Lob
	private String area;

	@Lob
	private String centerLatitude;

	@Lob
	private String centerLongitude;

	private int climateID;

	private Timestamp createdDate;

	private String fieldInfo;

	private String fieldName;

	private String fieldUrl;

	private int soilID;

	private int userID;

	public Field() {
	}

	public int getFieldID() {
		return this.fieldID;
	}

	public void setFieldID(int fieldID) {
		this.fieldID = fieldID;
	}

	public int getAddressID() {
		return this.addressID;
	}

	public void setAddressID(int addressID) {
		this.addressID = addressID;
	}

	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCenterLatitude() {
		return this.centerLatitude;
	}

	public void setCenterLatitude(String centerLatitude) {
		this.centerLatitude = centerLatitude;
	}

	public String getCenterLongitude() {
		return this.centerLongitude;
	}

	public void setCenterLongitude(String centerLongitude) {
		this.centerLongitude = centerLongitude;
	}

	public int getClimateID() {
		return this.climateID;
	}

	public void setClimateID(int climateID) {
		this.climateID = climateID;
	}

	public Timestamp getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public String getFieldInfo() {
		return this.fieldInfo;
	}

	public void setFieldInfo(String fieldInfo) {
		this.fieldInfo = fieldInfo;
	}

	public String getFieldName() {
		return this.fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getFieldUrl() {
		return this.fieldUrl;
	}

	public void setFieldUrl(String fieldUrl) {
		this.fieldUrl = fieldUrl;
	}

	public int getSoilID() {
		return this.soilID;
	}

	public void setSoilID(int soilID) {
		this.soilID = soilID;
	}

	public int getUserID() {
		return this.userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

}