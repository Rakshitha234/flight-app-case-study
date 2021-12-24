package com.flightApp.dto;

import java.time.LocalDate;

public class SearchResultDto {

	private String airlineName;
	private String logoUrl;
	private String flightId;
	private double price;
	private String time;
	private LocalDate date;
	private String endTime;
	private Long ScheduleId;
	
	public SearchResultDto() {}
	
	public SearchResultDto(String airlineName, String logoUrl, String flightId, double price, String time,
			LocalDate date, String endTime, Long scheduleId) {
		super();
		this.airlineName = airlineName;
		this.logoUrl = logoUrl;
		this.flightId = flightId;
		this.price = price;
		this.time = time;
		this.date = date;
		this.endTime = endTime;
		this.ScheduleId = scheduleId;
	}



	public String getAirlineName() {
		return airlineName;
	}

	public String getLogoUrl() {
		return logoUrl;
	}

	public String getFlightId() {
		return flightId;
	}

	public double getPrice() {
		return price;
	}

	public String getTime() {
		return time;
	}

	public LocalDate getDate() {
		return date;
	}

	public String getEndTime() {
		return endTime;
	}

	public Long getScheduleId() {
		return ScheduleId;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}

	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}

	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public void setScheduleId(Long scheduleId) {
		this.ScheduleId = scheduleId;
	}

	@Override
	public String toString() {
		return "SearchResultDTO [airlineName=" + airlineName + ", logoUrl=" + logoUrl + ", flightId=" + flightId
				+ ", price=" + price + ", time=" + time + ", date=" + date + ", endTime=" + endTime + ", ScheduleId="
				+ ScheduleId + "]";
	}
	
}
