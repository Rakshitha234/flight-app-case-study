package com.flightApp.dto;

import java.util.List;

public class BookTicketSuccessDto {

	private String name;
	private String email;
    private double billingAmmount;
    private List<PassengerDto> passengersList;
    
    public BookTicketSuccessDto() {}
    
	public BookTicketSuccessDto(String name, String email, double billingAmmount) {
		this.name = name;
		this.email = email;
		this.billingAmmount = billingAmmount;
	}
	
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public double getBillingAmmount() {
		return billingAmmount;
	}
	public List<PassengerDto> getPassengersList() {
		return passengersList;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setBillingAmmount(double billingAmmount) {
		this.billingAmmount = billingAmmount;
	}
	public void setPassengersList(List<PassengerDto> passengersList) {
		this.passengersList = passengersList;
	}

	@Override
	public String toString() {
		return "BookTicketSuccessDTO [name=" + name + ", email=" + email + ", billingAmmount=" + billingAmmount
				+ ", passengersList=" + passengersList + "]";
	}
	
	
}
