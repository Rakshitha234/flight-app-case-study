package com.flightApp.service;

import java.util.List;
import java.util.TreeSet;

import com.flightApp.dto.AirLine;
import com.flightApp.dto.DiscountDTO;
import com.flightApp.dto.FlightScheduleDTO;
import com.flightApp.dto.FlightSearchDetailsDTO;
import com.flightApp.entities.TicketEntities;
import com.flightApp.exception.AirLineAlreadyExistException;
import com.flightApp.exception.DiscountAlreadyExistException;
import com.flightApp.exception.FlightAlreadyScheduledException;

public interface AdminService {
	
	public boolean addNewAirline(AirLine airline) throws AirLineAlreadyExistException;

	public List<String> getAllAirlines();

	public boolean scheduleFlight(FlightScheduleDTO flight) throws FlightAlreadyScheduledException;

	public List<FlightScheduleDTO> getAllScheduleFlights();

	public boolean cancelScheduledFlight(FlightScheduleDTO flight);

	public boolean addDiscount(DiscountDTO discountDto) throws DiscountAlreadyExistException;

	public List<DiscountDTO> getDiscounts();

	public TreeSet<String> getAllAirportLocations();

	public List<FlightSearchDetailsDTO> getSearchFlightDetails();

	public List<TicketEntities> getAllTickets();

	public void cancelTicket(String pnrNumber);

}
