package com.ok.model;

import java.io.Serializable;
import javax.persistence.*;


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

	@Lob
	private String area;

	@Lob
	private String centerLatitude;

	@Lob
	private String centerLongitude;

	private String fieldInfo;

	private String fieldName;

	private String fieldUrl;

	public Field() {
	}

	public int getFieldID() {
		return this.fieldID;
	}

	public void setFieldID(int fieldID) {
		this.fieldID = fieldID;
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

}