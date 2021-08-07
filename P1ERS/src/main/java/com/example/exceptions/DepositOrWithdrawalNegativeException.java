package com.example.exceptions;

public class DepositOrWithdrawalNegativeException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public DepositOrWithdrawalNegativeException() {
		super("Deposited/Withdrew a negative amount of money");
	}
	

}
