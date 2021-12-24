package com.flightApp.exceptionhandler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.flightApp.exception.AirLineAlreadyExistException;
import com.flightApp.exception.CustomExceptionResponse;
import com.flightApp.exception.DiscountAlreadyExistException;
import com.flightApp.exception.FlightAlreadyScheduledException;

@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler {
	
	@ExceptionHandler(AirLineAlreadyExistException.class)
	public final ResponseEntity<CustomExceptionResponse> handleAirlineAlreadyExist(Exception e, WebRequest ex) {
		CustomExceptionResponse exceptionResponse = new CustomExceptionResponse(new Date(), 500, e.getMessage(),
				"Server Error : Airline Already Present ", ex.getDescription(false), e);
		return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(DiscountAlreadyExistException.class)
	public final ResponseEntity<CustomExceptionResponse> handleDiscountAlreadyExit(Exception e, WebRequest ex) {
		CustomExceptionResponse exceptionResponse = new CustomExceptionResponse(new Date(), 500, e.getMessage(),
				"Server Error : Discount Already Present ", ex.getDescription(false), e);
		return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(FlightAlreadyScheduledException.class)
	public final ResponseEntity<CustomExceptionResponse> handleFlightAlreadyScheduledException(Exception e, WebRequest ex) {
		CustomExceptionResponse exceptionResponse = new CustomExceptionResponse(new Date(), 500, e.getMessage(),
				"Server Error : Flight Already Scheduled Exception ", ex.getDescription(false), e);
		return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
	}
}
