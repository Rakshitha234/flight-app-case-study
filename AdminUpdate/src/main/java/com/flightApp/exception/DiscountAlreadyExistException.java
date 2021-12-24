package com.flightApp.exception;

public class DiscountAlreadyExistException extends Exception{

	private static final long serialVersionUID = 1L;

	public DiscountAlreadyExistException() {
		super();
	}

	public DiscountAlreadyExistException(String msg) {
		super(msg);
	}

	public DiscountAlreadyExistException(Exception exp) {
		super(exp);
	}

	public DiscountAlreadyExistException(Exception exp, String msg) {
		super(msg, exp);
	}
}
