package com.flightApp.controller;

import java.util.List;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.flightApp.dto.DiscountDto;
import com.flightApp.dto.FlightScheduleDto;
import com.flightApp.dto.FlightSearchDetailsDto;
import com.flightApp.dto.TicketDto;

@RestController
public class UsersAPIController { 

	@Autowired
	private RestTemplate restTemplate;
	private String baseUrL = "http://localhost:8080/";
	
	@GetMapping(value = "/airports-location-list")
	public TreeSet<String> getAllAirportLocations() {
		HttpHeaders headers=new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Object> requestEntity=new HttpEntity<>(headers);
		ResponseEntity<TreeSet<String>> responseEntity = restTemplate.exchange(this.baseUrL + "/getairportLocations",
				HttpMethod.GET, requestEntity, new ParameterizedTypeReference<TreeSet<String>>() {
				});
		
		HttpStatus statusCode=responseEntity.getStatusCode();
		System.out.println("Status code : "+statusCode);
		return responseEntity.getBody();
	}

	
	public List<FlightScheduleDto> getAllScheduledFlights() {
		HttpHeaders headers=new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Object> requestEntity=new HttpEntity<>(headers);
		ResponseEntity<List<FlightScheduleDto>> responseEntity = restTemplate.exchange(
				this.baseUrL + "/getAll-scheduleFlights", HttpMethod.GET, requestEntity,
				new ParameterizedTypeReference<List<FlightScheduleDto>>() {
				});
		HttpStatus statusCode=responseEntity.getStatusCode();
		System.out.println("Status code : "+statusCode);
		return responseEntity.getBody();
	}


	public List<FlightSearchDetailsDto> getSearchFlightDetails() {
		HttpHeaders headers=new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Object> requestEntity=new HttpEntity<>(headers);
		ResponseEntity<List<FlightSearchDetailsDto>> responseEntity  = restTemplate.exchange(
				this.baseUrL + "/flight-search-details", HttpMethod.GET, requestEntity,
				new ParameterizedTypeReference<List<FlightSearchDetailsDto>>() {
				});
		System.out.println("Request Completed");
		HttpStatus statusCode=responseEntity.getStatusCode();
		System.out.println("Status code : "+statusCode);
		return responseEntity.getBody();
	}


	@GetMapping("/get-discounts")
	public List<DiscountDto> getAllDiscounts() {
		HttpHeaders headers=new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Object> requestEntity=new HttpEntity<>(headers);
		ResponseEntity<List<DiscountDto>> responseEntity = restTemplate.exchange(this.baseUrL + "/get-discounts",
				HttpMethod.GET, requestEntity, new ParameterizedTypeReference<List<DiscountDto>>() {
				});
		HttpStatus statusCode=responseEntity.getStatusCode();
		System.out.println("Status code : "+statusCode);
		return responseEntity.getBody();
	}
	

	public void cancelTicket(String pnr) {
		restTemplate.exchange(this.baseUrL + "/cancel-ticket/"+pnr,
				HttpMethod.DELETE, null, new ParameterizedTypeReference<TicketDto>() {
				});
	}

}
