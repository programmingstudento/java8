package com.core.java;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Display {

	public static void main(String[] args) {
		Display display = new Display();
		final String[] languages = { "Java", "SQL", "Python", "Javascript", "Scala", "Typescript", "C#", "C++",
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

		System.out.println(display.firstEndsWithVowel(languages));
		System.out.println(display.firstLongestWord1(languages2));
		System.out.println(display.firstLongestWord2(languages2));

	}

	public String firstEndsWithVowel(final String[] languages) {
		return Stream.of(languages).filter(language -> language.matches("^[a-zA-Z]+[aeiou]$")).findFirst()
				.orElse("Not found");
	}

	public String firstLongestWord1(final String[] languages) {
		final int size = Stream.of(languages).mapToInt(String::length).max().getAsInt();
		return Stream.of(languages).filter(language -> language.length() == size).findFirst().orElse("Not Found");
	}

	public String firstLongestWord2(final String[] languages) {
		return Stream.of(languages).reduce((one, two) -> one.length() >= two.length() ? one : two).orElse("Not Found");
	}
}
