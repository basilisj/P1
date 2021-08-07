package com.example.exceptions;

public class UserNameIsTakenException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UserNameIsTakenException() {
		super("This username is already taken");
	}

}
