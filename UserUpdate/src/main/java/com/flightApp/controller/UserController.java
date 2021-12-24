package com.flightApp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flightApp.beans.BookingRequest;
import com.flightApp.dto.BookTicketSuccessDto;
import com.flightApp.dto.FlightSearchDetailsDto;
import com.flightApp.dto.SearchRequestDto;
import com.flightApp.dto.SearchResultDto;
import com.flightApp.dto.TicketDto;
import com.flightApp.entities.UsersProfile;
import com.flightApp.exception.UserAlreadyRegisteredException;
import com.flightApp.helperclasses.BookingSelection;
import com.flightApp.service.UsersService;

@RestController
public class UserController {

	@Autowired
	private UsersAPIController apiController;
	
	@Autowired
	private UsersService userService;

	@Autowired
	private BookingSelection bookingSelection;
	

	@GetMapping("/search-flights")
	public List<SearchResultDto> getFlightSearchResult(@RequestBody SearchRequestDto searchReqDto) {
		List<SearchResultDto> searchResults = new ArrayList<SearchResultDto>();
		List<FlightSearchDetailsDto> allScheduledFlights = apiController.getSearchFlightDetails();


		for (FlightSearchDetailsDto flight : allScheduledFlights) {
			if (searchReqDto.getSourcePlace().equals(flight.getFrom())
					&& searchReqDto.getDestinationPlace().equals(flight.getTo())
					&& searchReqDto.getDepartureDate().equals(flight.getDepatureDate())) {
				
				searchResults.add(new SearchResultDto(flight.getAirlineName(), flight.getLogoUrl(),
						flight.getFlightNumber(), flight.getPrice(), flight.getdTime(), flight.getDepatureDate(),
						flight.getaTime(), flight.getScheduleId()));
			}
		}
		return searchResults;
	}


	@PostMapping("/book-ticket")
	public BookTicketSuccessDto bookTicket(@RequestBody BookingRequest bookReq) {
		System.out.println(bookReq);

		if (bookReq.getTripType().equalsIgnoreCase("oneway")) {
			return bookingSelection.bookTicketForOneWay(bookReq);
		} else {
			return bookingSelection.bookTicketForRoundTrip(bookReq);
		}
	}
	
	
	@GetMapping("/get-tickets/{emailId}")
	public List<TicketDto> getAllBookedTickets(@PathVariable() String emailId){
		return userService.getAllTickets(emailId);
	}
	
	
	@DeleteMapping("/cancel-ticket/{pnr}")
	public void cancelBookedTicket(@PathVariable("pnr") String pnrNumber){
		apiController.cancelTicket(pnrNumber);
		userService.cancelTicket(pnrNumber);
	}
	

	@PostMapping("/register-user")
	public boolean registerNewUser(@RequestBody UsersProfile user) throws UserAlreadyRegisteredException {
		boolean flag = false;
		flag = userService.registerUser(user);
		return flag;
	}
}
