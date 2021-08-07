package com.example.dao;

import java.util.List;

import com.example.model.Reimbursement;

public interface ReimbursementDao {

	
	public void create(Reimbursement r);
	
    public Reimbursement updateReim(Reimbursement reimb);
	
	public Reimbursement selectByReimbId(int reimbId);
	
	public List<Reimbursement> selectAllReimb();
	
	public List<Reimbursement> selectByPending();
	
	public List<Reimbursement> selectByResolved();
}
