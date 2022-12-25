package com.core.java;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Streams {

	public static void main(String[] args) throws IOException {
		Random random = new Random();
		Stream<String> languages = Stream.<String>builder().add("Java ").add("Javascript").build();
		Stream<Integer> numbers = Stream.generate(() -> random.nextInt(1, 10)).limit(20);
		Stream<Integer> evens = Stream.iterate(0, num -> num + 2).limit(10);
		Stream<String> names = Pattern.compile(",").splitAsStream("java,javascript,typescript,sql");
		Path path = Paths.get("D:\\Spring.txt");
		Stream<String> items = Files.lines(path);
		display(languages);
		display(numbers);
		display(evens);
		display(names);
		display(items);
	}

	private static <T> void display(Stream<T> stream) {
		stream.forEach(System.out::println);
	}
}
