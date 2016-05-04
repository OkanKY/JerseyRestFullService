package com.ok.irragation.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the irregation database table.
 * 
 */
@Entity
@NamedQuery(name="Irregation.findAll", query="SELECT i FROM Irregation i")
public class Irregation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int irregationID;

	private int finishIrregationInfoID;

	private int irregationAmount;

	private int otherIrregationInfoID;

	private int productID;

	private int startIrregationInfoID;

	public Irregation() {
	}

	public int getIrregationID() {
		return this.irregationID;
	}

	public void setIrregationID(int irregationID) {
		this.irregationID = irregationID;
	}

	public int getFinishIrregationInfoID() {
		return this.finishIrregationInfoID;
	}

	public void setFinishIrregationInfoID(int finishIrregationInfoID) {
		this.finishIrregationInfoID = finishIrregationInfoID;
	}

	public int getIrregationAmount() {
		return this.irregationAmount;
	}

	public void setIrregationAmount(int irregationAmount) {
		this.irregationAmount = irregationAmount;
	}

	public int getOtherIrregationInfoID() {
		return this.otherIrregationInfoID;
	}

	public void setOtherIrregationInfoID(int otherIrregationInfoID) {
		this.otherIrregationInfoID = otherIrregationInfoID;
	}

	public int getProductID() {
		return this.productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public int getStartIrregationInfoID() {
		return this.startIrregationInfoID;
	}

	public void setStartIrregationInfoID(int startIrregationInfoID) {
		this.startIrregationInfoID = startIrregationInfoID;
	}

}