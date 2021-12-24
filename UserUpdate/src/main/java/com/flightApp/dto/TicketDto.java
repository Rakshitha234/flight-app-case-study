package com.flightApp.dto;

import java.time.LocalDate;

public class TicketDto {

	private Integer ticketId;
	private String pnrNumber;
	private boolean status;
	private String emailId;
	private String flightId;
	private String flightName;
	private String sourcePlace;
	private String destinationPlace;
	private LocalDate depatureDate;
	private String departTime;
	private String arrivaltime;
	private double ticketAmount;
	private String passengerName;
	private String passengerGender;
	private Integer passengerAge;
	private String seatNumber;
	private String optMeal;
	private boolean okToCancel;

	public TicketDto(Integer ticketId, String pnrNumber, boolean status, String emailId, String flightId,
			String flightName, String sourcePlace, String destinationPlace, LocalDate depatureDate, String departTime,
			String arrivaltime, double ticketAmount, String passengerName, String passengerGender, Integer passengerAge,
			String seatNumber, String optMeal) {
		this.ticketId = ticketId;
		this.pnrNumber = pnrNumber;
		this.status = status;
		this.emailId = emailId;
		this.flightId = flightId;
		this.flightName = flightName;
		this.sourcePlace = sourcePlace;
		this.destinationPlace = destinationPlace;
		this.depatureDate = depatureDate;
		this.departTime = departTime;
		this.arrivaltime = arrivaltime;
		this.ticketAmount = ticketAmount;
		this.passengerName = passengerName;
		this.passengerGender = passengerGender;
		this.passengerAge = passengerAge;
		this.seatNumber = seatNumber;
		this.optMeal = optMeal;
	}

	public Integer getTicketId() {
		return ticketId;
	}

	public String getPnrNumber() {
		return pnrNumber;
	}

	public boolean isStatus() {
		return status;
	}

	public String getEmailId() {
		return emailId;
	}

	public String getFlightId() {
		return flightId;
	}

	public String getFlightName() {
		return flightName;
	}

	public String getSourcePlace() {
		return sourcePlace;
	}

	public String getDestinationPlace() {
		return destinationPlace;
	}

	public LocalDate getDepatureDate() {
		return depatureDate;
	}

	public String getDepartTime() {
		return departTime;
	}

	public String getArrivaltime() {
		return arrivaltime;
	}

	public double getTicketAmount() {
		return ticketAmount;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public String getPassengerGender() {
		return passengerGender;
	}

	public Integer getPassengerAge() {
		return passengerAge;
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public String getOptMeal() {
		return optMeal;
	}

	public boolean isOkToCancel() {
		return okToCancel;
	}

	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}

	public void setPnrNumber(String pnrNumber) {
		this.pnrNumber = pnrNumber;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	public void setSourcePlace(String sourcePlace) {
		this.sourcePlace = sourcePlace;
	}

	public void setDestinationPlace(String destinationPlace) {
		this.destinationPlace = destinationPlace;
	}

	public void setDepatureDate(LocalDate depatureDate) {
		this.depatureDate = depatureDate;
	}

	public void setDepartTime(String departTime) {
		this.departTime = departTime;
	}

	public void setArrivaltime(String arrivaltime) {
		this.arrivaltime = arrivaltime;
	}

	public void setTicketAmount(double ticketAmount) {
		this.ticketAmount = ticketAmount;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public void setPassengerGender(String passengerGender) {
		this.passengerGender = passengerGender;
	}

	public void setPassengerAge(Integer passengerAge) {
		this.passengerAge = passengerAge;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}

	public void setOptMeal(String optMeal) {
		this.optMeal = optMeal;
	}

	public void setOkToCancel(boolean okToCancel) {
		this.okToCancel = okToCancel;
	}

	@Override
	public String toString() {
		return "TicketDTO [ticketId=" + ticketId + ", pnrNumber=" + pnrNumber + ", status=" + status + ", emailId="
				+ emailId + ", flightId=" + flightId + ", flightName=" + flightName + ", sourcePlace=" + sourcePlace
				+ ", destinationPlace=" + destinationPlace + ", depatureDate=" + depatureDate + ", departTime="
				+ departTime + ", arrivaltime=" + arrivaltime + ", ticketAmount=" + ticketAmount + ", passengerName="
				+ passengerName + ", passengerGender=" + passengerGender + ", passengerAge=" + passengerAge
				+ ", seatNumber=" + seatNumber + ", optMeal=" + optMeal + ", okToCancel=" + okToCancel + "]";
	}

}
