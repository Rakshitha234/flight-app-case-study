package com.flightApp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.flightApp.dto.AirLine;
import com.flightApp.dto.DiscountDTO;
import com.flightApp.dto.FlightScheduleDTO;
import com.flightApp.dto.FlightSearchDetailsDTO;
import com.flightApp.entities.AirlineEntities;
import com.flightApp.entities.DiscountEntities;
import com.flightApp.entities.FlightsScheduleEntities;
import com.flightApp.entities.TicketEntities;
import com.flightApp.exception.AirLineAlreadyExistException;
import com.flightApp.exception.DiscountAlreadyExistException;
import com.flightApp.exception.FlightAlreadyScheduledException;
import com.flightApp.repository.AirlineEntitiesRepository;
import com.flightApp.repository.DiscountRepository;
import com.flightApp.repository.FlightsScheduleRepository;
import com.flightApp.repository.TicketRepository;

@Service
public class AdminServiceImpl implements AdminService {


	@Autowired
	private AirlineEntitiesRepository airlineRepository;

	@Autowired
	private FlightsScheduleRepository flightsScheduleRepository;

	@Autowired
	private DiscountRepository discountRepository;

	@Autowired
	private TicketRepository ticketRepository;
	
	Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);

	@Override
	public boolean addNewAirline(AirLine airline) throws AirLineAlreadyExistException {

		AirlineEntities airlineEntities = new AirlineEntities(airline.getAirlineName(), airline.getAirlineLogo(),
				airline.getAirlineContactNumber(), airline.getAirLineAddress());

		boolean isExist = airlineRepository.existsByairlineName(airlineEntities.getAirlineName());
		if (isExist)
			throw new AirLineAlreadyExistException(
					"Airline :" + airline.getAirlineName() + " is already updated on the system");

		AirlineEntities saveedAirLineData = airlineRepository.save(airlineEntities);
		logger.info("New Airline Added  ");
		return saveedAirLineData != null;
	}

	// Get All Airline List
	@Override
	public List<String> getAllAirlines() {

		List<String> airlineList = new ArrayList<String>();
		List<AirlineEntities> airlineEntities = airlineRepository.findAll();

		for (AirlineEntities airline : airlineEntities) {
			airlineList.add(airline.getAirlineName());
		}
		
		return airlineList;
	}

	@Override
	public boolean scheduleFlight(FlightScheduleDTO flight) throws FlightAlreadyScheduledException {

		FlightsScheduleEntities schedule = new FlightsScheduleEntities(flight.getAirlineName(), flight.getFlightNumber(),
				flight.getFrom(), flight.getTo(), flight.getPrice(), flight.getDepatureDate(), flight.getdTime(),
				flight.getArivalDate(), flight.getaTime(), flight.getTotalSeats(), true);

		FlightsScheduleEntities isExist = flightsScheduleRepository.getScheduleFlightIfAlreadyAvailable(schedule.getFlightNumber(),
				schedule.getSourcePlace(), schedule.getDestinationPlace(), schedule.getDepatureDate(),
				schedule.getDepatureTime(), schedule.getArrivalDate(), schedule.getArrivalTime(),
				schedule.getTotalSeats());

		if (isExist != null) {
			throw new FlightAlreadyScheduledException(
					"Flight Number: " + flight.getFlightNumber() + " is already scheduled");
		}
		logger.info("Flight Scheduled ");
		FlightsScheduleEntities savedData = flightsScheduleRepository.save(schedule);

		return savedData != null;
	}

	@Override
	public List<FlightScheduleDTO> getAllScheduleFlights() {

		List<FlightScheduleDTO> schedulFlights = new ArrayList<FlightScheduleDTO>();
		List<FlightsScheduleEntities> allScheduledFlights = flightsScheduleRepository.findAll();

		for (FlightsScheduleEntities flight : allScheduledFlights) {
			FlightScheduleDTO scheduleFlight = new FlightScheduleDTO(flight.getFlightScheduleId(),
					flight.getAirlineName(), flight.getFlightNumber(), flight.getSourcePlace(),
					flight.getDestinationPlace(), flight.getTicketCost(), flight.getDepatureDate(),
					flight.getDepatureTime(), flight.getArrivalDate(), flight.getArrivalTime(), flight.getTotalSeats(),
					flight.isAvailable());
			logger.info("Getting All Scheduled Flights ");
			schedulFlights.add(scheduleFlight);
		}
		return schedulFlights;
	}

	@Override
	public boolean cancelScheduledFlight(FlightScheduleDTO flight) {
		FlightsScheduleEntities schedule = new FlightsScheduleEntities(flight.getAirlineName(), flight.getFlightNumber(),
				flight.getFrom(), flight.getTo(), flight.getPrice(), flight.getDepatureDate(), flight.getdTime(),
				flight.getArivalDate(), flight.getaTime(), flight.getTotalSeats(), flight.isStatus());
		schedule.setFlightScheduleId(flight.getScheduleId());
		logger.info("Cancelled Scheduled Flight ");
		FlightsScheduleEntities savedData = flightsScheduleRepository.save(schedule);
		return savedData != null;
	}

	@Override
	public boolean addDiscount(DiscountDTO discountDto) throws DiscountAlreadyExistException {
		boolean isExist = discountRepository.existsBydiscountCode(discountDto.getDiscountCode());
		if (isExist)
			throw new DiscountAlreadyExistException("Discount :" + discountDto.getDiscountCode() + " is already exist");

		DiscountEntities discount = new DiscountEntities(discountDto.getDiscountCode(), discountDto.getDiscountPercentage());
		discount.setDiscountId(0);
		DiscountEntities discountSaved = discountRepository.save(discount);
		return discountSaved != null;
	}

	@Override
	public List<DiscountDTO> getDiscounts() {
		List<DiscountDTO> discountsList = new ArrayList<DiscountDTO>();
		List<DiscountEntities> allDiscounts = discountRepository.findAll();
		for (DiscountEntities d : allDiscounts) {
			DiscountDTO dto = new DiscountDTO(d.getDiscountCode(), d.getDiscountPercentage());
			discountsList.add(dto);
		}
		return discountsList;
	}

	@Override
	public TreeSet<String> getAllAirportLocations() {
		TreeSet<String> allLocations = new TreeSet<String>();
		List<FlightsScheduleEntities> allScheduledFlights = flightsScheduleRepository.findAll();
		for (FlightsScheduleEntities f : allScheduledFlights) {
			allLocations.add(f.getDestinationPlace());
			allLocations.add(f.getSourcePlace());
		}
		return allLocations;
	}

	@Override
	public List<FlightSearchDetailsDTO> getSearchFlightDetails() {
		List<FlightSearchDetailsDTO> searchFlights = new ArrayList<FlightSearchDetailsDTO>();
		List<FlightsScheduleEntities> allScheduledFlights = flightsScheduleRepository.findAll();

		for (FlightsScheduleEntities flight : allScheduledFlights) {
			if (flight.isAvailable()) {
				FlightSearchDetailsDTO flightDetails = new FlightSearchDetailsDTO(flight.getFlightScheduleId(),
						flight.getAirlineName(), flight.getFlightNumber(), flight.getSourcePlace(),
						flight.getDestinationPlace(), flight.getTicketCost(), flight.getDepatureDate(),
						flight.getDepatureTime(), flight.getArrivalDate(), flight.getArrivalTime(),
						flight.getTotalSeats(), flight.isAvailable());

				String logoUrl = airlineRepository.getLogoUrl(flight.getAirlineName());
				flightDetails.setLogoUrl(logoUrl);
				searchFlights.add(flightDetails);
			}
		}
		return searchFlights;
	}

	@Override
	public List<TicketEntities> getAllTickets() {
		return ticketRepository.findAll();
	}

	@Override
	public void cancelTicket(String pnrNumber) {
		ticketRepository.cancelTicket(pnrNumber);
	}



}
