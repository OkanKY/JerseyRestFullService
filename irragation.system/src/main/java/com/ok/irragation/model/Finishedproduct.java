package com.ok.irragation.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the finishedproduct database table.
 * 
 */
@Entity
@NamedQuery(name="Finishedproduct.findAll", query="SELECT f FROM Finishedproduct f")
public class Finishedproduct implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int productID;

	private Timestamp finishDate;

	private int profitValue;

	public Finishedproduct() {
	}

	public int getProductID() {
		return this.productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public Timestamp getFinishDate() {
		return this.finishDate;
	}

	public void setFinishDate(Timestamp finishDate) {
		this.finishDate = finishDate;
	}

	public int getProfitValue() {
		return this.profitValue;
	}

	public void setProfitValue(int profitValue) {
		this.profitValue = profitValue;
	}

}