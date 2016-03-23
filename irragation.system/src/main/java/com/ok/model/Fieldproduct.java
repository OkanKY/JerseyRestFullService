package com.ok.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the fieldproduct database table.
 * 
 */
@Entity
@NamedQuery(name="Fieldproduct.findAll", query="SELECT f FROM Fieldproduct f")
public class Fieldproduct implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private FieldproductPK id;

	private Timestamp createdDate;

	private Timestamp finishDate;

	public Fieldproduct() {
	}

	public FieldproductPK getId() {
		return this.id;
	}

	public void setId(FieldproductPK id) {
		this.id = id;
	}

	public Timestamp getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public Timestamp getFinishDate() {
		return this.finishDate;
	}

	public void setFinishDate(Timestamp finishDate) {
		this.finishDate = finishDate;
	}

}