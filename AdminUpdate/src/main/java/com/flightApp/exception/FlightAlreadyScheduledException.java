package com.flightApp.exception;

public class FlightAlreadyScheduledException extends Exception {

	private static final long serialVersionUID = 1L;

	public FlightAlreadyScheduledException() {
		super();
	}

	public FlightAlreadyScheduledException(String msg) {
		super(msg);
	}

	public FlightAlreadyScheduledException(Exception exp) {
		super(exp);
	}

	public FlightAlreadyScheduledException(Exception exp, String msg) {
		super(msg, exp);
	}
}
