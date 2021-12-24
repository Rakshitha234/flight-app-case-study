package com.flightApp.dto;

public class DiscountDto {

	private Integer discountId;
	private String discountCode;
	private float discountPercentage;
	
	public DiscountDto() {}
	
	public DiscountDto(Integer discountId, String discountCode, float discountPercentage) {
		this.discountId = discountId;
		this.discountCode = discountCode;
		this.discountPercentage = discountPercentage;
	}
	
	public DiscountDto(String discountCode, float discountPercentage) {
		this.discountCode = discountCode;
		this.discountPercentage = discountPercentage;
	}
	
	public Integer getDiscountId() {
		return discountId;
	}
	public String getDiscountCode() {
		return discountCode;
	}
	public float getDiscountPercentage() {
		return discountPercentage;
	}
	public void setDiscountId(Integer discountId) {
		this.discountId = discountId;
	}
	public void setDiscountCode(String discountCode) {
		this.discountCode = discountCode;
	}
	public void setDiscountPercentage(float discountPercentage) {
		this.discountPercentage = discountPercentage;
	}
	
}
