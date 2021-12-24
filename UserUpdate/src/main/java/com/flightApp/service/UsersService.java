package com.flightApp.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightApp.dto.TicketDto;
import com.flightApp.entities.Ticket;
import com.flightApp.entities.UsersProfile;
import com.flightApp.exception.UserAlreadyRegisteredException;
import com.flightApp.repository.TicketRepository;
import com.flightApp.repository.UsersProfileRepository;

@Service
public class UsersService{

	@Autowired
	private TicketRepository ticketRepo;

	@Autowired
	private UsersProfileRepository userRepo;

	public boolean bookTicket(List<Ticket> ticketList) {

		int ticketSize = ticketList.size();
		int count = 0;

		for (Ticket ticket : ticketList) {
			ticketRepo.save(ticket);
			count++;
		}
		return ((ticketSize == count) );
	}

	public List<TicketDto> getAllTickets(String emailId) {

		List<TicketDto> ticketsDto = new ArrayList<TicketDto>();

		List<Ticket> ticketsList = ticketRepo.getTickets(emailId);
		for (Ticket t : ticketsList) {
			TicketDto ticket = new TicketDto(t.getTicketId(), t.getPnrNumber(), t.isStatus(), t.getEmailId(),
					t.getFlightId(), t.getFlightName(), t.getSourcePlace(), t.getDestinationPlace(),
					t.getDepatureDate(), t.getDepartTime(), t.getArrivaltime(), t.getTicketAmount(),
					t.getPassengerName(), t.getPassengerGender(), t.getPassengerAge(), t.getSeatNumber(),
					t.getOptMeal());
			ticket.setOkToCancel(checkAllowCancel(t.getDepatureDate()));
			ticketsDto.add(ticket);
		}
		return ticketsDto;
	}

	private boolean checkAllowCancel(LocalDate departureDate) {
		boolean flag = false;
		LocalDate date1 = LocalDate.now();
		LocalDate date2 = departureDate;
		LocalDate date3 = date2.minusDays(1);
		if (date2.equals(date1) || date3.equals(date1))
			flag = true;
		return flag;
	}

	public void cancelTicket(String pnrNumber) {
		ticketRepo.cancelTicket(pnrNumber);
	}

	public boolean registerUser(UsersProfile user) throws UserAlreadyRegisteredException {
		UsersProfile isExist = userRepo.getUserByEmailID(user.getEmailId());
		if (isExist != null)
			throw new UserAlreadyRegisteredException(
					"User " + user.getName() + " " + user.getEmailId() + " is Already Registered");

		user.setPassword((user.getPassword()));
		UsersProfile userSaved = userRepo.save(user);
		return userSaved != null;
	}

}
