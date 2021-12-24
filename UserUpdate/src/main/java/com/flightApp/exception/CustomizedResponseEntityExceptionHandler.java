package com.flightApp.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler {

	@ExceptionHandler(UserAlreadyRegisteredException.class)	
	public final ResponseEntity<CustomExceptionResponse> handleUserNotFoundException(Exception e, WebRequest ex) {
		CustomExceptionResponse exceptionResponse = new CustomExceptionResponse(new Date(), 500, e.getMessage(),
				"Server Error : User Already Registered Exception", ex.getDescription(false), e);
		return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
	}
	
}
