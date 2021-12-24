package com.flightApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.flightApp.entities.AirlineEntities;

public interface AirlineEntitiesRepository extends JpaRepository<AirlineEntities, Integer>{

	public boolean existsByairlineName(String airlineName);
	
	@Query("SELECT a.airlineLogo FROM AirlineEntities a WHERE a.airlineName = ?1")
	public String getLogoUrl(String airlineName);

}
