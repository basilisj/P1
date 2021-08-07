package com.example.dao;

import java.util.List;

import com.example.model.Users;

public interface UsersDao {

List<Users> getAllUsers();
	
	Users getUserByUserName(String username);
	
	void create(Users u);
	
	void update(Users u);
	
	void delete(Users u);

	
}
