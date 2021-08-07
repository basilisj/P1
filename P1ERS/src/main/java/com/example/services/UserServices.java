package com.example.services;

import com.example.dao.UsersDao;
import com.example.dao.UsersDaoHib;
import com.example.exceptions.InvalidCredentialsException;
import com.example.exceptions.UserDoesNotExistException;
import com.example.exceptions.UserNameIsTakenException;
import com.example.logging.Logging;
import com.example.model.UserRoles;
import com.example.model.Users;


public class UserServices {

	private UsersDao uDao;
	
	public UserServices(UsersDao u) {
		this.uDao = u;
	}
	
	public Users signUp( String first, String last, String email, String password, UserRoles userRole) throws UserNameIsTakenException {
		Users u = new Users( first, last, email, password, userRole);
		uDao.create(u);
		u= (uDao.getUserByUserName(u.getUsername()));
		if(u==null) {
			Logging.logger.warn("Username create that already exists.");
			throw new UserNameIsTakenException();
		}
		return u;
	}
	public Users signIn(String username, String password) throws UserDoesNotExistException, InvalidCredentialsException{
		System.out.println("In uServ");
		Users u = new Users();
		System.out.println(username);
		System.out.println(password);
		u = uDao.getUserByUserName(username);
		System.out.println(u);
		if(u.getUserId()==0) {
			Logging.logger.warn("User tried logging in that does not exist");
			throw new UserDoesNotExistException();
		}
		if(!u.getPassword().equals(password)) {
			Logging.logger.warn("User tried to login with invalid credentials");
			throw new InvalidCredentialsException();
		}
		else {
			Logging.logger.info("User was logged in");
			return u;
		}
	}
	public Users getUserByUsername(String username) {
		return uDao.getUserByUserName(username);
	}
	
}
