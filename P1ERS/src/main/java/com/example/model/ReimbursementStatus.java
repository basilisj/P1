package com.example.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="r_status")
public class ReimbursementStatus {
	
	@Id
	@Column(name="status_id")
	private int statusId;
	@Column(name="status")
	private String status;
	
	@OneToMany(mappedBy="status")
	private List<Reimbursement> rStatus = new ArrayList<Reimbursement>();

	

	public ReimbursementStatus() {
		super();
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public List<Reimbursement> getrStatus() {
		return rStatus;
	}

	public void setrStatus(List<Reimbursement> rStatus) {
		this.rStatus = rStatus;
	}

	public ReimbursementStatus(int statusId, String status) {
		super();
		this.statusId = statusId;
		this.status = status;
	}

	public ReimbursementStatus(int statusId, String status, List<Reimbursement> rStatus) {
		super();
		this.statusId = statusId;
		this.status = status;
		this.rStatus = rStatus;
	}

	public ReimbursementStatus(String status) {
		super();
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ReimbursementStatus [status=" + status + "]";
	}
	

}
