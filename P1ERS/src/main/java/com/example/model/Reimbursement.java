package com.example.model;



import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="reimb")
public class Reimbursement {

	@Id
	@Column(name="reimb_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int reimbId;
	
	@Column(name="amount", nullable=false)
	private int amount;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="submited", nullable=false)
	private Date createDate;
	
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="resolved")
	private Date updateDate;
	
	@Column(name="description")
	private String des;
	
	

	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="author_fk", referencedColumnName = "user_id")
	private Users rAuthor;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="resolver_fk", referencedColumnName = "user_id")
	private Users rResolver;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="status_fk")
	private ReimbursementStatus status;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="type_fk")
	private ReimbursementType type;
	
	
	public Reimbursement(int amount, String des, ReimbursementStatus status, ReimbursementType type) {
		super();
		this.amount = amount;
		this.des = des;
		this.status = status;
		this.type = type;
	}

	

	public Reimbursement() {
		super();
	}

	

	

	public Reimbursement(int amount, String des, Users rAuthor, Users rResolver, ReimbursementStatus status,
			ReimbursementType type) {
		super();
		this.amount = amount;
		this.des = des;
		this.rAuthor = rAuthor;
		this.rResolver = rResolver;
		this.status = status;
		this.type = type;
	}



	public Reimbursement(int reimbId, int amount, Date createDate, Date updateDate, String des, Users rAuthor,
			Users rResolver, ReimbursementStatus status, ReimbursementType type) {
		super();
		this.reimbId = reimbId;
		this.amount = amount;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.des = des;
		this.rAuthor = rAuthor;
		this.rResolver = rResolver;
		this.status = status;
		this.type = type;
	}



	public ReimbursementStatus getStatus() {
		return status;
	}

	public void setStatus(ReimbursementStatus status) {
		this.status = status;
	}

	public ReimbursementType getType() {
		return type;
	}

	public void setType(ReimbursementType type) {
		this.type = type;
	}

	public Reimbursement(int reimbId, int amount, Date createDate, Date updateDate, String des) {
		super();
		this.reimbId = reimbId;
		this.amount = amount;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.des = des;
	}

	

	public Users getrAuthor() {
		return rAuthor;
	}



	public void setrAuthor(Users rAuthor) {
		this.rAuthor = rAuthor;
	}



	public Users getrResolver() {
		return rResolver;
	}



	public void setrResolver(Users rResolver) {
		this.rResolver = rResolver;
	}



	public int getReimbId() {
		return reimbId;
	}

	public void setReimbId(int reimbId) {
		this.reimbId = reimbId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Reimbursement(int amount, String des) {
		super();
		this.amount = amount;
		this.des = des;
	}

	


	public Reimbursement(int amount, String des, Users rAuthor, ReimbursementStatus status, ReimbursementType type) {
		super();
		this.amount = amount;
		this.des = des;
		this.rAuthor = rAuthor;
		this.status = status;
		this.type = type;
	}



	@Override
	public String toString() {
		return "Reimbursement [reimbId=" + reimbId + ", amount=" + amount + ", createDate=" + createDate
				+ ", updateDate=" + updateDate + ", des=" + des + "]";
	}
	
	
}
