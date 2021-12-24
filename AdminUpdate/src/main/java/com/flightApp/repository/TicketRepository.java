package com.flightApp.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.flightApp.entities.TicketEntities;

public interface TicketRepository extends JpaRepository<TicketEntities, Integer>{

	@Modifying
	@Transactional
	@Query("UPDATE TicketEntities t set t.status=false where t.pnrNumber=:pnr")
	public void cancelTicket(@Param("pnr") String pnrNumber);
}
