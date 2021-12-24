package com.flightApp.beans;

public class PassengerRequest {

	private String passengerName;
    private String passengerGender;
    private Integer age;
    private String onwardSeat;
    private String returnSeat;
    private String optMeal;
	public PassengerRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PassengerRequest(String passengerName, String passengerGender, Integer age, String onwardSeat,
			String returnSeat, String optMeal) {
		super();
		this.passengerName = passengerName;
		this.passengerGender = passengerGender;
		this.age = age;
		this.onwardSeat = onwardSeat;
		this.returnSeat = returnSeat;
		this.optMeal = optMeal;
	}
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	public String getPassengerGender() {
		return passengerGender;
	}
	public void setPassengerGender(String passengerGender) {
		this.passengerGender = passengerGender;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getOnwardSeat() {
		return onwardSeat;
	}
	public void setOnwardSeat(String onwardSeat) {
		this.onwardSeat = onwardSeat;
	}
	public String getReturnSeat() {
		return returnSeat;
	}
	public void setReturnSeat(String returnSeat) {
		this.returnSeat = returnSeat;
	}
	public String getOptMeal() {
		return optMeal;
	}
	public void setOptMeal(String optMeal) {
		this.optMeal = optMeal;
	}
	@Override
	public String toString() {
		return "PassengerRequest [passengerName=" + passengerName + ", passengerGender=" + passengerGender + ", age="
				+ age + ", onwardSeat=" + onwardSeat + ", returnSeat=" + returnSeat + ", optMeal=" + optMeal + "]";
	}
    
  


    
}
