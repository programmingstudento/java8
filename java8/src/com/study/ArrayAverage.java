package com.study;

import java.util.Arrays;

public class ArrayAverage {

	public static double average(Integer[] numbers) {
		int total = Arrays.stream(numbers).map(Integer::intValue).reduce(0, (acc, num) -> acc + num);
		return total / (1.0 * numbers.length);
	}

	public static double average(int[] numbers) {
		return Arrays.stream(numbers).summaryStatistics().getAverage();
	}

	public static void main(String[] args) {
		System.out.println(average(new Integer[] { 1, 2, 3, 4, 5 }));
		System.out.println(average(new int[] { 1, 2, 3, 4, 5 }));
	}
}
