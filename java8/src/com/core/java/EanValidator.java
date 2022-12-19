package com.core.java;

import java.util.stream.IntStream;

final public class EanValidator {
	public static boolean validate(final String code) {
		final int size = code.length();
		final int total = IntStream.range(0, size)
				.map(number -> number % 2 == 0 ? 1 * Integer.valueOf(code.substring(number, number + 1))
						: 3 * Integer.valueOf(code.substring(number, number + 1)))
				.sum();
		final boolean isDivisibleByZero = modTen(total) == 0;
		final int checkSum = isDivisibleByZero ? 0 : 10 - modTen(total);
		return checkSum == Integer.valueOf(code.substring(size - 1)).intValue();
	}

	private static int modTen(final int number) {
		return number % 10;
	}
}
