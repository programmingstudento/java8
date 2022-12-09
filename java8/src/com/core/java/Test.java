package com.core.java;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Test {

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

	public static String showSequence(int value) {
		if (value < 0) {
			return value + "<0";
		} else if (value == 0) {
			return "0=0";
		} else {
			String string = IntStream.rangeClosed(0, value)
					.mapToObj(num -> num == value ? String.valueOf(num) : String.valueOf(num + ""))
					.collect(Collectors.joining());
			int total = IntStream.rangeClosed(0, value).sum();
			return String.format("%s = %d", string, total);
		}
	}
}
