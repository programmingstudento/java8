package com.core.java;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Display {

	public static void main(String[] args) {
		final String[] languages = { "Java", "SQL", "Python", "Javascript", "Scala", "Typesciprt", "C#", "C++",
				"Haskell", "C" };
		int size = languages.length;
		// style 1
		for (int index = 0; index < size; index++) {
			System.out.println(languages[index]);
		}

		// style 2
		for (String language : languages) {
			System.out.println(language);
		}

		// style 3
		Arrays.stream(languages).forEach(System.out::println);

		// all lower case names
		final String[] languages1 = new String[size];

		// style 1
		for (int index = 0; index < size; index++) {
			languages1[index] = languages[index].toLowerCase();
		}
		System.out.println(Arrays.toString(languages1));

		// style 2
		final String[] languages2 = Arrays.stream(languages).map(String::toLowerCase).toArray(String[]::new);
		System.out.println(Arrays.toString(languages2));
		System.out.println();
		System.out.println();

		// consonant starting words only printing
		// style 1
		final String pattern = "^[^AEIOU][a-zA-Z#+]*$";
		for (String language : languages) {
			if (language.matches(pattern)) {
				System.out.println(language);
			}
		}
		final Predicate<String> consonantStart = word -> word.matches("^[^AEIOU][a-zA-Z#+]*$");
		System.out.println();
		// style 2
		Stream.of(languages).filter(consonantStart).forEach(System.out::println);

		// counting number of languages that start with consonant.
		long count = Stream.of(languages).filter(consonantStart.negate()).count();
		System.out.format("The vowel start language count is : %d%n", count);
	}
}
