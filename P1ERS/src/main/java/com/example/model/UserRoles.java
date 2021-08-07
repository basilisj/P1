package com.example.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(value= {"hibernateLazyInitializer", "handler"})
@Table(name="user_roles")
public class UserRoles {

	@Id
	@Column(name="role_id")
	private int roleId;
	
	@Column(name="user_role")
	private String userRole;
	
	@OneToMany(mappedBy="userRoles", fetch=FetchType.LAZY)
	private List<Users> uList = new ArrayList<Users>();
	
	public UserRoles(String userRole, List<Users> uList) {
		super();
		this.userRole = userRole;
		this.uList = uList;
	}



	public UserRoles() {
		super();
	}



	public UserRoles(int roleId, String userRole) {
		super();
		this.roleId = roleId;
		this.userRole = userRole;
	}



	public UserRoles(String userRole) {
		super();
		this.userRole = userRole;
	}



	public int getRoleId() {
		
		return roleId;
	}



	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}



	public String getUserRole() {
		return userRole;
	}



	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}



	@Override
	public String toString() {
		return "UserRoles [roleId=" + roleId + ", userRole=" + userRole + "]";
	}



	
	
}
