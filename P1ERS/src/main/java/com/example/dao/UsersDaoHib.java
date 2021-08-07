package com.example.dao;

import org.hibernate.Transaction;

import java.util.List;

import org.hibernate.Session;

import com.example.model.Reimbursement;
import com.example.model.ReimbursementStatus;
import com.example.model.ReimbursementType;
import com.example.model.UserRoles;
import com.example.model.Users;
import com.example.util.HibernateUtil;

public class UsersDaoHib implements UsersDao{

	public UsersDaoHib() {
		
	}
	@Override
	public void create(Users u) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		
		ses.save(u);
		tx.commit();
	}
	@Override
	public void update(Users u) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		
		ses.update(u);
		tx.commit();
	}
	
	@Override
public Users getUserByUserName(String username) {
		
		Session ses = HibernateUtil.getSession();
		System.out.println("In get user by username");
	
		Users user = ses.createQuery("from Users where username=:username", Users.class).setString("username", username).uniqueResult();
		System.out.println(user);
		//ses.close();
		return user;
	}

@Override
public List<Users> getAllUsers() {
	Session ses = HibernateUtil.getSession();
	List<Users> uList = ses.createQuery("from Users", Users.class).list();
	return uList;
}
@Override
public void delete(Users u) {
	// TODO Auto-generated method stub
	
}
}
