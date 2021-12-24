package com.flightApp.dto;

public class AirLine {

	private Integer airlineId;
	private String airlineName;
	private String airlineLogo;
	private String airlineContactNumber;
	private String airLineAddress;

	public AirLine() {
	}

	public AirLine(Integer airlineId, String airlineName, String airlineLogo, String airlineContactNumber,
			String airLineAddress) {
		this.airlineName = airlineName;
		this.airlineLogo = airlineLogo;
		this.airlineContactNumber = airlineContactNumber;
		this.airLineAddress = airLineAddress;
	}
	

	public Integer getAirlineId() {
		return airlineId;
	}

	public String getAirlineName() {
		return airlineName;
	}

	public String getAirlineLogo() {
		return airlineLogo;
	}

	public String getAirlineContactNumber() {
		return airlineContactNumber;
	}

	public String getAirLineAddress() {
		return airLineAddress;
	}

	public void setAirlineId(Integer airlineId) {
		this.airlineId = airlineId;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}

	public void setAirlineLogo(String airlineLogo) {
		this.airlineLogo = airlineLogo;
	}

	public void setAirlineContactNumber(String airlineContactNumber) {
		this.airlineContactNumber = airlineContactNumber;
	}

	public void setAirLineAddress(String airLineAddress) {
		this.airLineAddress = airLineAddress;
	}

	@Override
	public String toString() {
		return "AirLine [airlineId=" + airlineId + ", airlineName=" + airlineName + ", airlineLogo=" + airlineLogo
				+ ", airlineContactNumber=" + airlineContactNumber + ", airLineAddress=" + airLineAddress + "]";
	}
}
