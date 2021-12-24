package com.flightApp.dto;

public class PassengerDto {

	private String passengerName;
	private String trip;
    private String onwardSeat;
    private String pnr;
	public PassengerDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PassengerDto(String passengerName, String trip, String onwardSeat, String pnr) {
		super();
		this.passengerName = passengerName;
		this.trip = trip;
		this.onwardSeat = onwardSeat;
		this.pnr = pnr;
	}
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	public String getTrip() {
		return trip;
	}
	public void setTrip(String trip) {
		this.trip = trip;
	}
	public String getOnwardSeat() {
		return onwardSeat;
	}
	public void setOnwardSeat(String onwardSeat) {
		this.onwardSeat = onwardSeat;
	}
	public String getPnr() {
		return pnr;
	}
	public void setPnr(String pnr) {
		this.pnr = pnr;
	}
	@Override
	public String toString() {
		return "PassengerDTO [passengerName=" + passengerName + ", trip=" + trip + ", onwardSeat=" + onwardSeat
				+ ", pnr=" + pnr + "]";
	}
    
    
    
    
}
