package com.core.java;

final public class Numbers {
	public static double twoDecimalPlaces(double number) {
		return Double.valueOf(
				String.format("%f", number > 0 ? Math.floor(number * 100) / 100 : Math.ceil(number * 100) / 100));
	}
}