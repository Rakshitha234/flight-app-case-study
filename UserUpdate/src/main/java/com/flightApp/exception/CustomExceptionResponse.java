package com.flightApp.exception;

import java.util.Date;

public class CustomExceptionResponse {

	private Date timeStamp;
	private int statusCode;
	private String message;
	private String details;
	private String requestedURI;
	private Exception e;

	public CustomExceptionResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomExceptionResponse(Date timeStamp, int statusCode, String message, String details, String requestedURI,
			Exception e) {
		super();
		this.timeStamp = timeStamp;
		this.statusCode = statusCode;
		this.message = message;
		this.details = details;
		this.requestedURI = requestedURI;
		this.e = e;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getRequestedURI() {
		return requestedURI;
	}

	public void setRequestedURI(String requestedURI) {
		this.requestedURI = requestedURI;
	}

	public Exception getE() {
		return e;
	}

	public void setE(Exception e) {
		this.e = e;
	}

	@Override
	public String toString() {
		return "CustomExceptionResponse [timeStamp=" + timeStamp + ", statusCode=" + statusCode + ", message=" + message
				+ ", details=" + details + ", requestedURI=" + requestedURI + ", e=" + e + "]";
	}

}
