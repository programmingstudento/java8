package com.study;

import static java.lang.Math.pow;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class One {

	public static void main(String[] args) {

	}

	public static long ipsBetween(String start, String end) {
		final int NUMBER = 256;
		var one = start.split("\\.");
		var two = end.split("\\.");
		int size = one.length;
		return LongStream.range(0, size).map(index -> (int) Math.pow(NUMBER, size - 1 - index)
				* (Long.valueOf(two[(int) index]) - Long.valueOf(one[(int) index]))).sum();

	}

	public static double solution(int[] arr1, int[] arr2) {
		return IntStream.range(0, arr1.length).mapToDouble(index -> pow(arr2[index] - arr1[index], 2d)).sum()
				/ arr1.length;
	}

}
