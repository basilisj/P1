package com.example.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(value= {"hibernateLazyInitializer", "handler"})
@Table(name="users")
public class Users {

	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	
	@Column(name="first_name", nullable=false)
	private String firstName;
	
	@Column(name="last_name", nullable=false)
	private String lastName;
	
	@Column(name="username", unique=true, nullable=false)
	private String username;
	
	@Column(name="email", unique =true, nullable=false)
	private String email;
	
	@Column(name="password", nullable=false)
	private String password;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="role_FK", updatable=false, insertable=true)
	private UserRoles userRoles;
/*
	@JsonIgnore
	@OneToMany(mappedBy="re", fetch=FetchType.LAZY)
	private List<Reimbursement> rList = new ArrayList<Reimbursement>();
	*/
	
	
	public Users() {
		super();
	}

	public Users(int userId, String firstName, String lastName, String email, String password, UserRoles userRoles) {
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email= email;
		//this.username = lastName + firstName + (new Random().nextInt(9000)+1000);
		this.password = password;
		this.userRoles = userRoles;
	}

	public Users(int userId, String firstName, String lastName, String email, String password) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email= email;
		this.username = lastName + firstName + (new Random().nextInt(9000)+1000);
		this.password = password;
		this.userRoles = userRoles;
	}

	public Users( String firstName, String lastName, String email, String password, UserRoles userRoles) {
		super();
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = lastName + firstName + (new Random().nextInt(9000)+1000);
		this.email=email;
		this.password = password;
		this.userRoles = userRoles;
	}

	

	public Users(int i, String string, String string2, String string3, String string4, String string5, UserRoles r1) {
		// TODO Auto-generated constructor stub
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
/*
	public Users(int userId, String firstName, String lastName, String username, String email, String password,
			UserRoles userRoles, List<Reimbursement> rList) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.email = email;
		this.password = password;
		this.userRoles = userRoles;
		this.rList = rList;
	}
*/
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserRoles getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(UserRoles userRoles) {
		this.userRoles = userRoles;
	}
/*
	public List<Reimbursement> getrList() {
		return rList;
	}

	public void settList(List<Reimbursement> rList) {
		this.rList = rList;
	}
*/
	@Override
	public String toString() {
		return "Users [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", username="
				+ username + ", email=" + email + ", password=" + password + ", userRoles=" + userRoles + ", rList="
				 + "]";
	}

	
	
	
}
