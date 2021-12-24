package com.flightApp.helperclasses;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.flightApp.beans.BookingRequest;
import com.flightApp.beans.PassengerRequest;
import com.flightApp.controller.UsersAPIController;
import com.flightApp.dto.BookTicketSuccessDto;
import com.flightApp.dto.FlightScheduleDto;
import com.flightApp.dto.PassengerDto;
import com.flightApp.entities.Ticket;
import com.flightApp.service.UsersService;

@Component
public class BookingSelection {

	@Autowired
	private UsersService userService;

	@Autowired
	private UsersAPIController userAPIController;

	public BookTicketSuccessDto bookTicketForOneWay(BookingRequest bookingRequest) {
		BookTicketSuccessDto success = new BookTicketSuccessDto(bookingRequest.getName(), bookingRequest.getEmail(),
				bookingRequest.getBillingAmmount());
		List<PassengerDto> passengerDto = new ArrayList<PassengerDto>();

		List<Ticket> ticketsList = new ArrayList<Ticket>();
		FlightScheduleDto flightDeatils = getFlightDeatils(bookingRequest.getOnwardScheduleId());

		for (PassengerRequest pass : bookingRequest.getPassengersList()) {
			String pnr = generatePNRNumber();
			Ticket ticket = new Ticket(pnr, true, bookingRequest.getEmail(), flightDeatils.getFlightNumber(), flightDeatils.getAirlineName(),
					flightDeatils.getFrom(), flightDeatils.getTo(), flightDeatils.getDepatureDate(), flightDeatils.getdTime(),
					flightDeatils.getaTime(), bookingRequest.getBillingAmmount(), pass.getPassengerName(), pass.getPassengerGender(), pass.getAge(),
					pass.getOnwardSeat(), pass.getOptMeal());
			ticketsList.add(ticket);
			passengerDto.add(new PassengerDto(pass.getPassengerName(),"On Ward", pass.getOnwardSeat(), pnr));
		}
		boolean flag  = userService.bookTicket(ticketsList);
		if(flag)
		success.setPassengersList(passengerDto);
		return success;
	}

	public BookTicketSuccessDto bookTicketForRoundTrip(BookingRequest bookingRequest) {

		BookTicketSuccessDto success = new BookTicketSuccessDto(bookingRequest.getName(), bookingRequest.getEmail(),
				bookingRequest.getBillingAmmount());
		List<PassengerDto> passengerDto = new ArrayList<PassengerDto>();

		// One way
		List<Ticket> ticketsList = new ArrayList<Ticket>();
		FlightScheduleDto flightDeatils1 = getFlightDeatils(bookingRequest.getOnwardScheduleId());

		for (PassengerRequest pass : bookingRequest.getPassengersList()) {
			String pnr = generatePNRNumber();

			Ticket ticket = new Ticket(pnr, true, bookingRequest.getEmail(), flightDeatils1.getFlightNumber(),
					flightDeatils1.getAirlineName(), flightDeatils1.getFrom(), flightDeatils1.getTo(), flightDeatils1.getDepatureDate(),
					flightDeatils1.getdTime(), flightDeatils1.getaTime(), bookingRequest.getBillingAmmount(), pass.getPassengerName(),
					pass.getPassengerGender(), pass.getAge(), pass.getOnwardSeat(), pass.getOptMeal());

			ticketsList.add(ticket);
			passengerDto.add(new PassengerDto(pass.getPassengerName(),"On Ward", pass.getOnwardSeat(), pnr));
		}

		//  Two-Way:
		FlightScheduleDto flightDeatils2 = getFlightDeatils(bookingRequest.getRoundScheduleId());

		for (PassengerRequest pass : bookingRequest.getPassengersList()) {
			String pnr = generatePNRNumber();
			Ticket ticket = new Ticket(pnr, true, bookingRequest.getEmail(), flightDeatils2.getFlightNumber(),
					flightDeatils2.getAirlineName(), flightDeatils2.getFrom(), flightDeatils2.getTo(), flightDeatils2.getDepatureDate(),
					flightDeatils2.getdTime(), flightDeatils2.getaTime(), bookingRequest.getBillingAmmount(), pass.getPassengerName(),
					pass.getPassengerGender(), pass.getAge(), pass.getReturnSeat(), pass.getOptMeal());

			ticketsList.add(ticket);
			passengerDto.add(new PassengerDto(pass.getPassengerName(),"Return", pass.getReturnSeat(), pnr));
		}
		boolean flag = userService.bookTicket(ticketsList);
		if(flag)
		success.setPassengersList(passengerDto);
		return success;
	}


	public FlightScheduleDto getFlightDeatils(Long scheduleId) {
		List<FlightScheduleDto> allScheduledFlights = userAPIController.getAllScheduledFlights();
		System.out.println(allScheduledFlights.toString());
		FlightScheduleDto flightDeatils = new FlightScheduleDto();
		for (FlightScheduleDto flight : allScheduledFlights) {
			if (flight.getScheduleId().equals(scheduleId)) {
				flightDeatils = flight;
			}
		}
		return flightDeatils;
	}

	public String generatePNRNumber() {
		StringBuffer pnr = new StringBuffer("PNR");
		String txt = new String(Math.random() + "");
		pnr.append(txt.substring(2, 10));
		return pnr.toString();
	}
}
