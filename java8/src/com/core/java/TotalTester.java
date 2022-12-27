package com.core.java;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

public class TotalTester {

	public static void main(String[] args) {
		final List<BigInteger> prices = Arrays.asList(new BigInteger("50"), new BigInteger("100"), new BigInteger("20"),
				new BigInteger("40"), new BigInteger("45"));
		System.out.format("Total : %d", totalGreaterThan(prices, BigInteger.valueOf(45)));
	}

	private static BigInteger totalGreaterThan(final List<BigInteger> items, BigInteger number) {
		return items.stream().filter(item -> item.compareTo(number) > 0).reduce(BigInteger.ZERO, BigInteger::add);
	}
}
