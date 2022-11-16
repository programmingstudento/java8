package com.study;

public class Business {

	private Merchant merchant;
	private int year;
	private int value;

	public Business(Merchant merchant, int year, int value) {
		this.merchant = merchant;
		this.year = year;
		this.value = value;
	}

	public Merchant getMerchant() {
		return this.merchant;
	}

	public int getYear() {
		return this.year;
	}

	public int getValue() {
		return this.value;
	}

	@Override
	public String toString() {
		return String.format("Business [merchant=%s, year=%s, value=%s]", merchant, year, value);
	}

}