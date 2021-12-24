package com.flightApp.dto;

import java.time.LocalDate;

public class SearchRequestDto {

	private String sourcePlace;
	private String destinationPlace;
	private LocalDate departureDate;

	public SearchRequestDto() {}
	
	public SearchRequestDto(String sourcePlace, String destinationPlace, LocalDate departureDate) {
		this.sourcePlace = sourcePlace;
		this.destinationPlace = destinationPlace;
		this.departureDate = departureDate;
	}
	
	public String getSourcePlace() {
		return sourcePlace;
	}
	public String getDestinationPlace() {
		return destinationPlace;
	}
	public LocalDate getDepartureDate() {
		return departureDate;
	}
	public void setSourcePlace(String sourcePlace) {
		this.sourcePlace = sourcePlace;
	}
	public void setDestinationPlace(String destinationPlace) {
		this.destinationPlace = destinationPlace;
	}
	public void setDepartureDate(LocalDate departureDate) {
		this.departureDate = departureDate;
	}
	
	@Override
	public String toString() {
		return "SearchRequestDTO [sourcePlace=" + sourcePlace + ", destinationPlace=" + destinationPlace
				+ ", departureDate=" + departureDate + "]";
	}
}
