package com.ok.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the fieldproduct database table.
 * 
 */
@Embeddable
public class FieldproductPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int fieldID;

	private int productID;

	public FieldproductPK() {
	}
	public int getFieldID() {
		return this.fieldID;
	}
	public void setFieldID(int fieldID) {
		this.fieldID = fieldID;
	}
	public int getProductID() {
		return this.productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof FieldproductPK)) {
			return false;
		}
		FieldproductPK castOther = (FieldproductPK)other;
		return 
			(this.fieldID == castOther.fieldID)
			&& (this.productID == castOther.productID);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.fieldID;
		hash = hash * prime + this.productID;
		
		return hash;
	}
}