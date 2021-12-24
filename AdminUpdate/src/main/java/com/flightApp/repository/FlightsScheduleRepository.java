package com.flightApp.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.flightApp.entities.FlightsScheduleEntities;

public interface FlightsScheduleRepository extends JpaRepository<FlightsScheduleEntities, Long> {

	@Query("SELECT s FROM FlightsScheduleEntities s WHERE s.flightNumber = ?1 and s.sourcePlace = ?2 and s.destinationPlace =?3 and s.depatureDate =?4 and s.depatureTime=?5 and s.arrivalDate=?6 and arrivalTime=?7 and totalSeats=?8")
	public FlightsScheduleEntities getScheduleFlightIfAlreadyAvailable(String fNumber, String sPlace, String dPlace,
			LocalDate dDate, String dTime, LocalDate aDate, String aTime, Integer totalSeats);
	
}
