package com.flightApp.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UsersProfile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	private String name;
	private String age;
	private String emailId;
	private String password;
	
	public UsersProfile() {}
	
	public UsersProfile(String name, String age, String emailId, String password) {
		this.name = name;
		this.age = age;
		this.emailId = emailId;
		this.password = password;
	}
	
	public UsersProfile(Integer userId, String name, String age, String emailId, String password) {
		this.userId = userId;
		this.name = name;
		this.age = age;
		this.emailId = emailId;
		this.password = password;
	}

	public Integer getUserId() {
		return userId;
	}
	public String getName() {
		return name;
	}
	public String getAge() {
		return age;
	}
	public String getEmailId() {
		return emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "UsersProfile [userId=" + userId + ", name=" + name + ", age=" + age + ", emailId=" + emailId
				+ ", password=" + password + "]";
	}
}
