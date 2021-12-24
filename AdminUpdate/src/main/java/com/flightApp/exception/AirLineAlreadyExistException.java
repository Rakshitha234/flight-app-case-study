package com.flightApp.exception;

public class AirLineAlreadyExistException extends Exception {

	private static final long serialVersionUID = 1L;

	public AirLineAlreadyExistException() {
		super();
	}

	public AirLineAlreadyExistException(String msg) {
		super(msg);
	}

	public AirLineAlreadyExistException(Exception exp) {
		super(exp);
	}

	public AirLineAlreadyExistException(Exception exp, String msg) {
		super(msg, exp);
	}

}
