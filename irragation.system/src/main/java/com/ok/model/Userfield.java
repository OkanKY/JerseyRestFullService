package com.ok.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the userfield database table.
 * 
 */
@Entity
@NamedQuery(name="Userfield.findAll", query="SELECT u FROM Userfield u")
public class Userfield implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UserfieldPK id;

	private Timestamp createdDate;

	public Userfield() {
	}

	public UserfieldPK getId() {
		return this.id;
	}

	public void setId(UserfieldPK id) {
		this.id = id;
	}

	public Timestamp getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

}