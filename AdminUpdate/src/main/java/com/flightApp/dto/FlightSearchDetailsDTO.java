package com.flightApp.dto;

import java.time.LocalDate;

public class FlightSearchDetailsDTO {

	private Long scheduleId;
	private String airlineName;
	private String flightNumber;
	private String from;
	private String to;
	private double price;
	private LocalDate depatureDate;
	private String dTime;
	private LocalDate arivalDate;
	private String aTime;
	private Integer totalSeats;
	private boolean status;
	private String logoUrl;
	
	public FlightSearchDetailsDTO() {}
	
	public FlightSearchDetailsDTO(Long scheduleId, String airlineName, String flightNumber, String from, String to,
			double price, LocalDate depatureDate, String dTime, LocalDate arivalDate, String aTime, Integer totalSeats,
			boolean status) {
		this.scheduleId = scheduleId;
		this.airlineName = airlineName;
		this.flightNumber = flightNumber;
		this.from = from;
		this.to = to;
		this.price = price;
		this.depatureDate = depatureDate;
		this.dTime = dTime;
		this.arivalDate = arivalDate;
		this.aTime = aTime;
		this.totalSeats = totalSeats;
		this.status = status;
	}
	
	public Long getScheduleId() {
		return scheduleId;
	}
	public String getAirlineName() {
		return airlineName;
	}
	public String getFlightNumber() {
		return flightNumber;
	}
	public String getFrom() {
		return from;
	}
	public String getTo() {
		return to;
	}
	public double getPrice() {
		return price;
	}
	public LocalDate getDepatureDate() {
		return depatureDate;
	}
	public String getdTime() {
		return dTime;
	}
	public LocalDate getArivalDate() {
		return arivalDate;
	}
	public String getaTime() {
		return aTime;
	}
	public Integer getTotalSeats() {
		return totalSeats;
	}
	public boolean isStatus() {
		return status;
	}
	public String getLogoUrl() {
		return logoUrl;
	}
	public void setScheduleId(Long scheduleId) {
		this.scheduleId = scheduleId;
	}
	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setDepatureDate(LocalDate depatureDate) {
		this.depatureDate = depatureDate;
	}
	public void setdTime(String dTime) {
		this.dTime = dTime;
	}
	public void setArivalDate(LocalDate arivalDate) {
		this.arivalDate = arivalDate;
	}
	public void setaTime(String aTime) {
		this.aTime = aTime;
	}
	public void setTotalSeats(Integer totalSeats) {
		this.totalSeats = totalSeats;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}

	@Override
	public String toString() {
		return "FlightSearchDetailsDTO [scheduleId=" + scheduleId + ", airlineName=" + airlineName + ", flightNumber="
				+ flightNumber + ", from=" + from + ", to=" + to + ", price=" + price + ", depatureDate=" + depatureDate
				+ ", dTime=" + dTime + ", arivalDate=" + arivalDate + ", aTime=" + aTime + ", totalSeats=" + totalSeats
				+ ", status=" + status + ", logoUrl=" + logoUrl + "]";
	}
	
}
