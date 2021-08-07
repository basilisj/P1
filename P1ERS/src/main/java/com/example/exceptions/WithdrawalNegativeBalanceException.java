package com.example.exceptions;

public class WithdrawalNegativeBalanceException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public WithdrawalNegativeBalanceException() {
		super("Withdrew more money than was in account");
	}

}
