package com.core.java;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class TestingTime {

	public static void main(String[] args) {
		String word = "JAVA";

		/*
		 * System.out.println("Method One"); LocalDateTime start = LocalDateTime.now();
		 * String reverse = StringUtils.reverseOne(word); LocalDateTime end =
		 * LocalDateTime.now(); System.out.println(reverse);
		 * displayNanoSeconds(ChronoUnit.NANOS.between(start, end));
		 */

		// time checking
		System.out.println("Method Two");
		LocalDateTime start = LocalDateTime.now();
		String reverse = StringUtils.reverseSix(word);
		LocalDateTime end = LocalDateTime.now();
		System.out.println(reverse);
		displayNanoSeconds(ChronoUnit.NANOS.between(start, end));
		/*
		 * System.out.println("Method Three"); LocalDateTime start =
		 * LocalDateTime.now(); String reverse = StringUtils.reverseThree(word);
		 * LocalDateTime end = LocalDateTime.now(); System.out.println(reverse);
		 * displayNanoSeconds(ChronoUnit.NANOS.between(start, end));
		 * 
		 * System.out.println("Method Four"); LocalDateTime start = LocalDateTime.now();
		 * String reverse = StringUtils.reverseFour(word); LocalDateTime end =
		 * LocalDateTime.now(); System.out.println(reverse);
		 * displayNanoSeconds(ChronoUnit.NANOS.between(start, end));
		 * 
		 * System.out.println("Method Five"); LocalDateTime start = LocalDateTime.now();
		 * String reverse = StringUtils.reverseFive(word); LocalDateTime end =
		 * LocalDateTime.now(); System.out.println(reverse);
		 * displayNanoSeconds(ChronoUnit.NANOS.between(start, end));
		 * 
		 * System.out.println("Method Six"); LocalDateTime start = LocalDateTime.now();
		 * String reverse = StringUtils.reverseSix(word); LocalDateTime end =
		 * LocalDateTime.now(); System.out.println(reverse);
		 * displayNanoSeconds(ChronoUnit.NANOS.between(start, end));
		 */

	}

	private static void displayNanoSeconds(long nanoSeconds) {
		System.out.printf("Time taken : %d nanoseconds.%n%n", nanoSeconds);
	}

}
