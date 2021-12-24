package com.flightApp.dto;

public class DiscountDTO {

	private Integer discountId;
	private String discountCode;
	private float discountPercentage;
	
	public DiscountDTO() {}
	
	public DiscountDTO(Integer discountId, String discountCode, float discountPercentage) {
		this.discountId = discountId;
		this.discountCode = discountCode;
		this.discountPercentage = discountPercentage;
	}
	
	public DiscountDTO(String discountCode, float discountPercentage) {
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
