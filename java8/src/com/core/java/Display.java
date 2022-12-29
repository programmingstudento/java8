package com.core.java;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Display {

	public static void main(String[] args) throws IOException {
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

		"Java1Python2C#3".chars().filter(number -> number % 2 == 0).forEach(System.out::println);

		final List<Clerk> clerks = new ArrayList<>();
		clerks.add(new Clerk("Rama", 28));
		clerks.add(new Clerk("Sita", 25));
		clerks.add(new Clerk("Rita", 25));
		clerks.add(new Clerk("Karishma", 31));

		System.out.println();
		System.out.println(clerks);
		Comparator<Clerk> sortByAscendingAge = (clerk1, clerk2) -> Integer.compare(clerk1.getAge(), clerk2.getAge());
		clerks.stream().sorted(sortByAscendingAge).forEach(System.out::println);
		System.out.println(clerks);
		System.out.println();

		Comparator<Clerk> sortByDescendingAge = sortByAscendingAge.reversed();
		Comparator<Clerk> sortByNameAscending = (clerk1, clerk2) -> clerk1.getName().compareTo(clerk2.getName());
		clerks.stream().sorted(sortByDescendingAge).findFirst()
				.ifPresent((final Clerk clerk) -> System.out.format("The Oldest Clerk is %s", clerk));
		System.out.println();

		clerks.stream().sorted(sortByDescendingAge.thenComparing(sortByNameAscending)).forEach(System.out::println);
		System.out.println();

		final Function<Clerk, Integer> ageComparing = clerk -> clerk.getAge();
		clerks.stream().sorted(Comparator.comparing(ageComparing)).forEach(System.out::println);
		System.out.println();

		List<Clerk> clerkNameLengthGreaterThan4 = clerks.stream()
				.filter((final Clerk clerk) -> clerk.getName().length() > 4).collect(Collectors.toList());
		System.out.println(clerkNameLengthGreaterThan4);
		Map<Integer, List<Clerk>> clerkMap = clerks.stream().collect(Collectors.groupingBy(Clerk::getAge));
		System.out.println(clerkMap);
		clerks.stream()
				.collect(Collectors.groupingBy(clerk -> clerk.getName().subSequence(0, 1),
						Collectors.reducing(BinaryOperator.minBy(sortByAscendingAge))))
				.forEach((t, u) -> System.out.println(t + ":" + u.get()));

		System.out.println();
		Files.list(Paths.get("D:\\")).forEach(System.out::println);

		System.out.println();
		Files.list(Paths.get("D:\\")).filter(file -> Files.isDirectory(file, new LinkOption[] {}))
				.forEach(System.out::println);

		final List<Person> one = Arrays.asList(new Person(24, Classification.SENIOR),
				new Person(22, Classification.JUNIOR), new Person(21, Classification.SOPHOMORE),
				new Person(19, Classification.FRESHMAN), new Person(18, Classification.FRESHMAN),
				new Person(27, Classification.SENIOR));

		final Predicate<Person> freshman = person -> person.getClassification() == Classification.FRESHMAN;
		final Predicate<Person> sophomore = person -> person.getClassification() == Classification.SOPHOMORE;
		
		System.out.println(addAge(sophomore, one));
		System.out.println(addAge(freshman, one));
	}

	public static int addAge(final Predicate<Person> personFilter,final List<Person> persons) {
		return persons.stream().filter(personFilter).mapToInt(Person::getAge).sum();
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
