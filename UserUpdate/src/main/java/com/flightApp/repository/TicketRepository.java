package com.flightApp.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.flightApp.entities.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer>{

	
	@Query(value = "SELECT * from ticket t WHERE t.email_id = ?1",nativeQuery = true)
	public List<Ticket> getTickets(String emailId);
	
	@Modifying
	@Transactional
	@Query("UPDATE Ticket t set t.status=false where t.pnrNumber=:pnr")
	public void cancelTicket(@Param("pnr") String pnrNumber);

}
