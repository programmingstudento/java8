package com.core.java;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public final class StringUtils {

	private StringUtils() {

	}

	/**
	 * Reversing the words using Stack class(implementation class of List Interface)
	 * and its predefined - method.
	 * 
	 * @param words to be reversed
	 * @return new reverse of the string since java.lang.String is immutable.
	 */
	public static String reverseSix(String words) {
		if (nullCheck(words)) {
			throw new IllegalArgumentException("Parameter must be not null.");
		}
		Stack<Character> stack = new Stack<>();
		StringBuilder result = new StringBuilder();
		// Pushing to stack
		for (int index = 0, size = words.length(); index < size; index++) {
			stack.push(words.charAt(index));
		}

		// Popping off the stack
		while (!stack.isEmpty()) {
			result.append(stack.pop());
		}
		return result.toString();
	}

	/**
	 * Reversing the words using StringBuilder predefined - method.
	 * 
	 * @param words to be reversed
	 * @return new reverse of the string since java.lang.String is immutable.
	 */
	public static String reverseOne(String words) {
		if (nullCheck(words)) {
			throw new IllegalArgumentException("Parameter must be not null.");
		}
		return new StringBuilder(words).reverse().toString();
	}

	/**
	 * Reversing the words using traditional for-loop and String.charAt(int index)
	 * method.
	 * 
	 * @param words to be reversed
	 * @return new reverse of the string since java.lang.String is immutable.
	 */
	public static String reverseTwo(String words) {
		if (nullCheck(words)) {
			throw new IllegalArgumentException("Parameter must be not null.");
		}
		String reverse = "";
		for (int index = 0, size = words.length(); index < size; index++) {
			reverse += words.charAt(size - index - 1);

		}
		return reverse;
	}

	/**
	 * Reversing the words using IntStream Interface and String.charAt(int index)
	 * method.
	 * 
	 * @param words to be reversed
	 * @return new reverse of the string since java.lang.String is immutable.
	 */
	public static String reverseThree(String words) {
		if (nullCheck(words)) {
			throw new IllegalArgumentException("Parameter must be not null.");
		}
		StringBuilder reverse = new StringBuilder();
		int size = words.length();
		IntStream.range(0, size).forEach(index -> reverse.append(words.charAt(size - index - 1)));
		return reverse.toString();
	}

	/**
	 * Reversing the words using List Interface,Collections class reverse(). method.
	 * 
	 * @param words to be reversed
	 * @return new reverse of the string since java.lang.String is immutable.
	 */
	public static String reverseFour(String words) {
		if (nullCheck(words)) {
			throw new IllegalArgumentException("Parameter must be not null.");
		}
		List<String> text = Arrays.asList(words.split(""));
		Collections.reverse(text);
		return String.join("", text);
	}

	/**
	 * Reversing the words using Stream Interface,Collectors class,map(),collect() .
	 * 
	 * @param words to be reversed
	 * @return new reverse of the string since java.lang.String is immutable.
	 */
	public static String reverseFive(String words) {
		if (nullCheck(words)) {
			throw new IllegalArgumentException("Parameter must be not null.");
		}
		return Stream.of(words).map(word -> new StringBuffer(word).reverse()).collect(Collectors.joining(""));
	}

	private static boolean nullCheck(String words) {
		return Objects.isNull(words);
	}
}
