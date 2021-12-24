package com.flightApp.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DiscountEntities {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer discountId;
	private String discountCode;
	private float discountPercentage;
	
	public DiscountEntities() {}

	public DiscountEntities(String discountCode, float discountPercentage) {
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

	@Override
	public String toString() {
		return "Discounts [discountId=" + discountId + ", discountCode=" + discountCode + ", discountPercentage="
				+ discountPercentage + "]";
	}
	
}
