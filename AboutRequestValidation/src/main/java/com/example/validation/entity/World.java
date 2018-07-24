package com.example.validation.entity;

public class World {

	private String country;
	private Integer phone;
	
	@Override
	public String toString() {
		return "World [country=" + country + ", phone=" + phone + "]";
	}

	public Integer getPhone() {
		return phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}
