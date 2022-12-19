package com.core.java;

import java.util.stream.IntStream;

final public class Kata {

	public static int alternateSqSum(final int[] arr) {
		final int size = arr.length;
		return IntStream.range(0, size).map(index -> index % 2 == 0 ? arr[index] : arr[index] * arr[index]).sum();
	}
}