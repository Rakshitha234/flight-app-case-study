package com.flightApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightApp.entities.DiscountEntities;

public interface DiscountRepository extends JpaRepository<DiscountEntities, Integer>{

	public boolean existsBydiscountCode(String airlineName);
}
