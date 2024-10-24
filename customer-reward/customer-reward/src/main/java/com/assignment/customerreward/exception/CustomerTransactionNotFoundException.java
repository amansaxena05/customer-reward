package com.assignment.customerreward.exception;

public class CustomerTransactionNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomerTransactionNotFoundException() {
		super();
	}
	
	public CustomerTransactionNotFoundException (String message) {
		super(message);
	}
}
