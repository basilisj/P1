package com.example.dao;

import java.sql.Connection;
import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.example.model.Reimbursement;
import com.example.util.HibernateUtil;

public class ReimbursementDaoDB {

	public ReimbursementDaoDB() {
        super();
    }

    //public void setConnection(Connection connection) {
    //    this.connection = connection;
   // }

    public static List<Reimbursement> getAllReimbursements() {

        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();

        try {
            String hql = "FROM Reimbursement";
            Query query = session.createQuery(hql);
            List results = query.list();

            tx.commit();
            return results;

        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }finally {
           session.close();
        }

        return getAllReimbursements();
        }

    public List<Reimbursement> getReimbursementsByUserId(int userId) throws DatabaseException, SQLException {
        Session session = SessionUtility.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        try {
            logger.info("UserId value is: " + userId);

            String hql = "FROM Reimbursement WHERE author= ?1";
            Query query = session.createQuery(hql).setParameter(1, userId);
            List results = query.list();

            tx.commit();
            return results;

        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }finally {
            session.close();
        }

        return getReimbursementsByUserId(userId);
    }


    public Reimbursement addReimbursement(Reimbursement reimbursement) throws DatabaseException,
            SQLException {

        Session session = SessionUtility.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        try {

            Reimbursement newReim  = new Reimbursement();
            newReim = reimbursement;

            logger.info("new reimbursement value is: " + reimbursement);

            session.save(newReim);

            tx.commit();
            return newReim;

        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }finally {
            session.close();
        }

        return addReimbursement(reimbursement);
    }


    public List<Reimbursement> filterReimbursementsByStatusId(int statusId) throws DatabaseException, SQLException {

        Session session = SessionUtility.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        try {

            String hql = "FROM Reimbursement r WHERE r.statusId = ?1";
            Query query = session.createQuery(hql).setParameter(1, statusId);
            List results = query.list();

            System.out.println("filterByStatusId: " + results);
            tx.commit();
            return results;

        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }finally {
            session.close();
        }

        return filterReimbursementsByStatusId(statusId);
    }

    public Reimbursement approveReimbursementById(int reimId, Reimbursement reimbursement) throws DatabaseException,
            SQLException {

        Session session = SessionUtility.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        try {

            Reimbursement newReim = new Reimbursement();
            newReim = reimbursement;

            String hql = "UPDATE Reimbursement r SET r.statusId = ?1, r.resolver = ?2, r.resolved = ?3 WHERE" +
                    " r.reimId = ?4";
            Query query = session.createQuery(hql);
            query.setParameter(1, newReim.getStatusId());
            query.setParameter(2, newReim.getResolver());
            query.setParameter(3, newReim.getResolved());
            query.setParameter(4, newReim.getId());

            int result = query.executeUpdate();

            tx.commit();
            return newReim;

        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }finally {
            session.close();
        }

        return approveReimbursementById(reimId, reimbursement);

    }

}
}
