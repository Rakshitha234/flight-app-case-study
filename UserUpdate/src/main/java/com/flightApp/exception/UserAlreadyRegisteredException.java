package com.flightApp.exception;

public class UserAlreadyRegisteredException extends Exception{

	private static final long serialVersionUID = 1L;

	
	public UserAlreadyRegisteredException() {
		super();
	}

	public UserAlreadyRegisteredException(String msg) {
		super(msg);
	}

	public UserAlreadyRegisteredException(Exception exp) {
		super(exp);
	}

	public UserAlreadyRegisteredException(Exception exp, String msg) {
		super(msg, exp);
	}
}
