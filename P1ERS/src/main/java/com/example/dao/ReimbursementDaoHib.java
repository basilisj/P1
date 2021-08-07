package com.example.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.example.model.Reimbursement;
import com.example.model.ReimbursementStatus;
import com.example.model.ReimbursementType;
import com.example.model.Users;
import com.example.util.HibernateUtil;

public class ReimbursementDaoHib implements ReimbursementDao{

	public ReimbursementDaoHib() {
		
	}
	@Override
	public void create(Reimbursement r) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		Reimbursement newReim = new Reimbursement();
	    newReim = r;

	    String hql = "INSERT Reimbursement r SET r.statusId = ?1, r.author = ?2, r.createDate = ?3, r.typeId = ?4 WHERE" +
	            " r.reimbId = ?5";
	    Query query = ses.createQuery(hql);
	    query.setParameter(1, newReim.getStatus());
	    query.setParameter(2, newReim.getrAuthor());
	    query.setParameter(3, newReim.getCreateDate());
	    query.setParameter(4, newReim.getType());
	    query.setParameter(5, newReim.getReimbId());

	    int result = query.executeUpdate();

		ses.save(r);
		tx.commit();
	}
	@Override
	public Reimbursement updateReim(Reimbursement reimb) {
		
			Session ses = HibernateUtil.getSession();
			Transaction tx = ses.beginTransaction();
			ses.update(reimb);
			tx.commit();
			return ses.get(Reimbursement.class, reimb.getReimbId());
		}
		
	@Override
	public Reimbursement selectByReimbId(int reimbId) {
		Session ses = HibernateUtil.getSession();
		Query q = ses.createQuery("from Reimbursement where id=:reimb_id");
		q.setInteger("id", reimbId);
		Reimbursement reim = (Reimbursement) q.uniqueResult();
		return reim;
	}
	@Override
	public List<Reimbursement> selectAllReimb() {
		Session ses = HibernateUtil.getSession();
		List<Reimbursement> rList = ses.createQuery("from Reimbursement", Reimbursement.class).list();
		return rList;
	}
	@Override
	public List<Reimbursement> selectByPending() {
		Session ses = HibernateUtil.getSession();
		String sql = "SELECT * FROM reimb WHERE status =:status_fk";
		SQLQuery query = HibernateUtil.getSession().createSQLQuery(sql);
		query.addEntity(Reimbursement.class);
		query.setParameter("status", new ReimbursementStatus(1, "PENDING"));
		return query.list();
	}
	@Override
	public List<Reimbursement> selectByResolved() {
		Session ses = HibernateUtil.getSession();
		String sql = "SELECT * FROM reimb WHERE status NOT =:status_fk";
		SQLQuery query = HibernateUtil.getSession().createSQLQuery(sql);
		query.addEntity(Reimbursement.class);
		query.setParameter("status", new ReimbursementStatus(1, "PENDING"));
		return query.list();
	}

	public List<Reimbursement> getReimbursementsByUserId(int user_Id) {
        Session ses = HibernateUtil.getSession();
                

            String hql = "FROM Reimbursement WHERE author_fk= ?1";
            Query q = ses.createQuery(hql).setParameter(1, user_Id);
            List res = q.list();
            
            return res;

        
    }
	public Reimbursement approveReimbursementById(int reimbId, Reimbursement reimbursement)  {

Session ses = HibernateUtil.getSession();
Transaction tx = ses.beginTransaction();
    Reimbursement newReim = new Reimbursement();
    newReim = reimbursement;

    String hql = "UPDATE Reimbursement r SET r.statusId = ?1, r.resolver = ?2, r.updateDate = ?3 WHERE" +
            " r.reimbId = ?4";
    Query query = ses.createQuery(hql);
    query.setParameter(1, newReim.getStatus());
    query.setParameter(2, newReim.getrResolver());
    query.setParameter(3, newReim.getUpdateDate());
    query.setParameter(4, newReim.getReimbId());

    int result = query.executeUpdate();

    tx.commit();
    return newReim;
}
	public ReimbursementType selectByType() {
		Session ses = HibernateUtil.getSession();
		ReimbursementType rList = (ReimbursementType) ses.createQuery("from ReimbursementType", ReimbursementType.class).list();
		return rList;
	}
	public ReimbursementStatus selectByStatus() {
		Session ses = HibernateUtil.getSession();
		ReimbursementStatus rList = (ReimbursementStatus) ses.createQuery("from ReimbursementStatus", ReimbursementStatus.class).list();
		return rList;
	}
}

