package com.ok.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the userfield database table.
 * 
 */
@Embeddable
public class UserfieldPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int fieldID;

	private int userID;

	public UserfieldPK() {
	}
	public int getFieldID() {
		return this.fieldID;
	}
	public void setFieldID(int fieldID) {
		this.fieldID = fieldID;
	}
	public int getUserID() {
		return this.userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof UserfieldPK)) {
			return false;
		}
		UserfieldPK castOther = (UserfieldPK)other;
		return 
			(this.fieldID == castOther.fieldID)
			&& (this.userID == castOther.userID);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.fieldID;
		hash = hash * prime + this.userID;
		
		return hash;
	}
}