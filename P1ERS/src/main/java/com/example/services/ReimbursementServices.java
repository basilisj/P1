package com.example.services;

import java.util.List;

import com.example.dao.ReimbursementDao;
import com.example.dao.ReimbursementDaoHib;
import com.example.dao.UsersDao;
import com.example.dao.UsersDaoHib;
import com.example.model.Reimbursement;
import com.example.model.ReimbursementStatus;
import com.example.model.ReimbursementType;
import com.example.model.Users;

public class ReimbursementServices {

	private ReimbursementDao rDao;
	private UsersDao uDao;

	private ReimbursementDaoHib hDao;
	
	public ReimbursementServices(ReimbursementDao r, UsersDao u ) {
		this.rDao=r;
		this.uDao=u;
	}
	public Reimbursement createReim(int amount,String des, Users rAuthor, ReimbursementStatus status, ReimbursementType type) {
		Reimbursement r = new Reimbursement( amount, des, rAuthor, status, type );
		rDao.create(r);
		
		return r;
	}
	public List<Reimbursement> selectAllReimb() {
		
		List<Reimbursement> rList = rDao.selectAllReimb();
		
		return rList;
	}
public ReimbursementStatus selectByStatus() {
		
		ReimbursementStatus rList = hDao.selectByStatus();
		
		return rList;
	}
public ReimbursementType selectByType() {
	
	ReimbursementType rList = hDao.selectByType();
	
	return rList;
}
}
