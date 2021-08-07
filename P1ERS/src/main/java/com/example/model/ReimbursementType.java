package com.example.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="r_type")
public class ReimbursementType {
	
	@Id
	@Column(name="type_id")
	private int typeId;
	@Column(name="reim_type")
	private String reimbursementType;

	@OneToMany(mappedBy="type")
	private List<Reimbursement> tType = new ArrayList<Reimbursement>();
	
	
	public ReimbursementType() {
		super();
	}

	public ReimbursementType(int typeId, String reimbursementType) {
		super();
		this.typeId = typeId;
		this.reimbursementType = reimbursementType;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public ReimbursementType(String reimbursementType) {
		super();
		this.reimbursementType = reimbursementType;
	}

	public String getReimbursementType() {
		return reimbursementType;
	}

	public void setReimbursementType(String reimbursementType) {
		this.reimbursementType = reimbursementType;
	}

	@Override
	public String toString() {
		return "ReimbursementType [reimbursementType=" + reimbursementType + "]";
	}

	
}
