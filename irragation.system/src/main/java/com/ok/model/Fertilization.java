package com.ok.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the fertilization database table.
 * 
 */
@Entity
@NamedQuery(name="Fertilization.findAll", query="SELECT f FROM Fertilization f")
public class Fertilization implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int fertilizationID;

	private Timestamp createdDate;

	private int fertilizationAmount;

	private int otherFertýlýzatýonInfoID;

	private int productID;

	public Fertilization() {
	}

	public int getFertilizationID() {
		return this.fertilizationID;
	}

	public void setFertilizationID(int fertilizationID) {
		this.fertilizationID = fertilizationID;
	}

	public Timestamp getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public int getFertilizationAmount() {
		return this.fertilizationAmount;
	}

	public void setFertilizationAmount(int fertilizationAmount) {
		this.fertilizationAmount = fertilizationAmount;
	}

	public int getOtherFertýlýzatýonInfoID() {
		return this.otherFertýlýzatýonInfoID;
	}

	public void setOtherFertýlýzatýonInfoID(int otherFertýlýzatýonInfoID) {
		this.otherFertýlýzatýonInfoID = otherFertýlýzatýonInfoID;
	}

	public int getProductID() {
		return this.productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

}