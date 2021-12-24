package com.flightApp.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FlightsScheduleEntities {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long flightScheduleId;
	private String airlineName;
	private String flightNumber;
	private String sourcePlace;
	private String destinationPlace;
	private double ticketCost;
	private LocalDate depatureDate;
	private String depatureTime;
	private LocalDate arrivalDate; 
	private String arrivalTime;
	private Integer totalSeats;
	private boolean isAvailable;
	
	public FlightsScheduleEntities() {}
	
	public FlightsScheduleEntities(String airlineName, String flightNumber, String sourcePlace, String destinationPlace,
			double ticketCost, LocalDate depatureDate, String depatureTime, LocalDate arrivalDate, String arrivalTime,
			Integer totalSeats, boolean isAvailable) {
		this.airlineName = airlineName;
		this.flightNumber = flightNumber;
		this.sourcePlace = sourcePlace;
		this.destinationPlace = destinationPlace;
		this.ticketCost = ticketCost;
		this.depatureDate = depatureDate;
		this.depatureTime = depatureTime;
		this.arrivalDate = arrivalDate;
		this.arrivalTime = arrivalTime;
		this.totalSeats = totalSeats;
		this.isAvailable = isAvailable;
	}
	
	public Long getFlightScheduleId() {
		return flightScheduleId;
	}
	public String getAirlineName() {
		return airlineName;
	}
	public String getFlightNumber() {
		return flightNumber;
	}
	public String getSourcePlace() {
		return sourcePlace;
	}
	public String getDestinationPlace() {
		return destinationPlace;
	}
	public double getTicketCost() {
		return ticketCost;
	}
	public LocalDate getDepatureDate() {
		return depatureDate;
	}
	public String getDepatureTime() {
		return depatureTime;
	}
	public LocalDate getArrivalDate() {
		return arrivalDate;
	}
	public String getArrivalTime() {
		return arrivalTime;
	}
	public Integer getTotalSeats() {
		return totalSeats;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setFlightScheduleId(Long flightScheduleId) {
		this.flightScheduleId = flightScheduleId;
	}
	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public void setSourcePlace(String sourcePlace) {
		this.sourcePlace = sourcePlace;
	}
	public void setDestinationPlace(String destinationPlace) {
		this.destinationPlace = destinationPlace;
	}
	public void setTicketCost(double ticketCost) {
		this.ticketCost = ticketCost;
	}
	public void setDepatureDate(LocalDate depatureDate) {
		this.depatureDate = depatureDate;
	}
	public void setDepatureTime(String depatureTime) {
		this.depatureTime = depatureTime;
	}
	public void setArrivalDate(LocalDate arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public void setTotalSeats(Integer totalSeats) {
		this.totalSeats = totalSeats;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	
	@Override
	public String toString() {
		return "FlightsSchedule [flightScheduleId=" + flightScheduleId + ", airlineName=" + airlineName
				+ ", flightNumber=" + flightNumber + ", sourcePlace=" + sourcePlace + ", destinationPlace="
				+ destinationPlace + ", ticketCost=" + ticketCost + ", depatureDate=" + depatureDate + ", depatureTime="
				+ depatureTime + ", arrivalDate=" + arrivalDate + ", arrivalTime=" + arrivalTime + ", totalSeats="
				+ totalSeats + ", isAvailable=" + isAvailable + "]";
	}
	
}
