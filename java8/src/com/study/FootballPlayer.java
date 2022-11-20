package com.study;

import java.util.Optional;

public class FootballPlayer {

	private String name;
	private int age;
	private Bike bike;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Optional<Bike> getBike() {
		return Optional.ofNullable(bike);
	}

	public void setBike(Bike bike) {
		this.bike = bike;
	}

	@Override
	public String toString() {
		return String.format("FootballPlayer [name=%s, age=%s, bike=%s]", name, age, bike);
	}

}
