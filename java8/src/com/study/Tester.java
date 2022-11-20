package com.study;

public class Tester {

	public static void main(String[] args) {
		Bike bike = new Bike("Hero Bike", 5000d);
		FootballPlayer footballPlayer = new FootballPlayer();
		footballPlayer.setAge(25);
		footballPlayer.setName("Pele");

		System.out.println(footballPlayer);

		if (footballPlayer.getBike().isPresent()) {
			System.out.println(footballPlayer.getBike());
		}

		footballPlayer.setBike(bike);

		if (footballPlayer.getBike().isPresent()) {
			System.out.println(footballPlayer.getBike());
		}
	}

}
