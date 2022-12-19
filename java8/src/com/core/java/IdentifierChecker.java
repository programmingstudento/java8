package com.core.java;

final public class IdentifierChecker {
	public static boolean isValid(final String idn) {
		final String regex = "^[a-zA-Z_$][a-zA-Z_$0-9]*$";
		return idn.matches(regex);
	}
}