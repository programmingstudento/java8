package com.study;

public class Merchant {

	private String name;
	private String city;

	public Merchant(String name, String city) {
		this.name = name;
		this.city = city;
	}

	public String getName() {
		return this.name;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String newCity) {
		this.city = newCity;
	}

	@Override
	public String toString() {
		return String.format("Business [name=%s, city=%s]", name, city);
	}

}