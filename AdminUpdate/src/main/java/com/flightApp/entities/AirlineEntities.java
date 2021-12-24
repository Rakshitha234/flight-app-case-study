package com.flightApp.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AirlineEntities {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer airlineId;
	private String airlineName;
	private String airlineLogo;
	private String airlineContactNumber;
	private String airLineAddress;

	public AirlineEntities() {
	}

	public AirlineEntities(String airlineName, String airlineLogo, String airlineContactNumber, String airLineAddress) {
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

	public String getairlineLogo() {
		return airlineLogo;
	}

	public String getAirlineContactNumber() {
		return airlineContactNumber;
	}

	public String getAirLineAddress() {
		return airLineAddress;
	}

	public void setAirlineId(int airlineId) {
		this.airlineId = airlineId;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}

	public void setairlineLogo(String airlineLogo) {
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
		return "AirlineMaster [airlineId=" + airlineId + ", airlineName=" + airlineName + ", airlineLogo=" + airlineLogo
				+ ", airlineContactNumber=" + airlineContactNumber + ", airLineAddress=" + airLineAddress + "]";
	}

}
