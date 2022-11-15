package com.study;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Predicates {

	public static void main(String[] args) throws FileNotFoundException {
		List<String> languages = new ArrayList<>(Arrays.asList("Java", "Sql", "C#", "C++", "C", "Scala", "Kotlin"));
		filters(languages, word -> word.length() > 2).forEach(System.out::println);
		languages.stream().map(String::length).forEach(System.out::println);

		List<Student> students = new ArrayList<>(Arrays.asList(new Student(21, "One"), new Student(22, "Two"),
				new Student(23, "Three"), new Student(24, "Four")));

		Function<Integer, Student> first = Student::new;
		students.add(first.apply(24));
		BiFunction<Integer, String, Student> second = Student::new;
		students.add(second.apply(25, "Five"));
		System.out.println(students);
	}

	public static <T> List<T> filters(List<T> list, Predicate<T> predicate) {
		return list.stream().filter(item -> predicate.test(item)).collect(Collectors.toList());
	}
}
