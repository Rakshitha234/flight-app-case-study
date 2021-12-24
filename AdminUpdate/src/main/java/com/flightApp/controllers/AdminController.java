package com.flightApp.controllers;

import java.net.URI;
import java.util.List;
import java.util.TreeSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.flightApp.dto.AirLine;
import com.flightApp.dto.DiscountDTO;
import com.flightApp.dto.FlightScheduleDTO;
import com.flightApp.dto.FlightSearchDetailsDTO;
import com.flightApp.entities.TicketEntities;
import com.flightApp.exception.AirLineAlreadyExistException;
import com.flightApp.exception.DiscountAlreadyExistException;
import com.flightApp.exception.FlightAlreadyScheduledException;
import com.flightApp.service.AdminService;

@RestController
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	Logger logger = LoggerFactory.getLogger(AdminController.class);

	// Register New AirLine
	@PostMapping("/register-airline")
	public ResponseEntity<Object> addNewAirline(@RequestBody AirLine airline) throws AirLineAlreadyExistException {
		adminService.addNewAirline(airline);
		URI path=ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(airline.getAirlineId()).toUri();
		return ResponseEntity.created(path).build();
		
//		boolean flag = false;
//		flag = adminService.addNewAirline(airline);
//		return flag;
	}

	// Get All AirLines
	@GetMapping("/getAirlines")
	public List<String> getAllAirlines() {
		logger.info("Getting Airlines ");
		return adminService.getAllAirlines();
	}
	
	

	// Create a Schedule for a Flight
	@PostMapping("/schedule-flight")
	public boolean scheduleFlight(@RequestBody FlightScheduleDTO flight) throws FlightAlreadyScheduledException {
		return adminService.scheduleFlight(flight);
	}

	// Get All Scheduled Flights
	@GetMapping("/getAll-scheduleFlights")
	public List<FlightScheduleDTO> getAllScheduleFlights() {
		logger.info("Getting Scheduled Flights ");
		return adminService.getAllScheduleFlights();
	}

	// Cancel Scheduled Flights
	@PutMapping("/cancel-scheduleFlights")
	public boolean cancelScheduledFlight(@RequestBody FlightScheduleDTO flight) {
		return adminService.cancelScheduledFlight(flight);
	}

	// Add Discount:
	@PostMapping("/add-discounts")
	public boolean addDiscount(@RequestBody DiscountDTO discountDto) throws DiscountAlreadyExistException {
		boolean flag = false;
		flag = adminService.addDiscount(discountDto);
		return flag;
	}

	// Get Discounts:
	@GetMapping("/get-discounts")
	public List<DiscountDTO> getAllDiscounts() {
		return adminService.getDiscounts();
	}

	// API RESPONSE:
	@GetMapping("/getairportLocations")
	public TreeSet<String> getAllAirportLocations() {
		return adminService.getAllAirportLocations();
	}


	@GetMapping("/flight-search-details")
	public List<FlightSearchDetailsDTO> getSearchFlightDetails() {
		return adminService.getSearchFlightDetails();
	}

	@GetMapping("/getAll-tickets")
	public List<TicketEntities> getAllBookedTickets() {
		return adminService.getAllTickets();
	}


	@DeleteMapping("/cancel-ticket/{pnr}")
	public void cancelBookedTicket(@PathVariable("pnr") String pnrNumber) {
		adminService.cancelTicket(pnrNumber);
	}
}
