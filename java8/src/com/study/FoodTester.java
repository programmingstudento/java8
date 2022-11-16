package com.study;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FoodTester {

	public static void main(String[] args) {
		// Three highest calorie food names
		List<String> foods = Food.foods().stream()
				.sorted((o1, o2) -> Integer.compare(o2.getCalories(), o1.getCalories())).limit(3)
				.map(food -> food.getName().concat(" " + food.getCalories())).collect(Collectors.toList());
		System.out.println(foods);
		System.out.println("-------------------------------");
		Food.foods().stream().sorted((o1, o2) -> Integer.compare(o2.getCalories(), o1.getCalories())).map(food -> {
			System.out.println(food);
			return food.getName().concat(" " + food.getCalories());
		}).limit(3).forEach(System.out::println);

		int vowelCount = Food.foods().stream().map(Food::getName)
				.mapToInt(food -> food.replaceAll("[^aeiouAEIOU]", "").length()).sum();
		System.out.println(vowelCount);

		System.out.println(Arrays.asList("Java", "SQL").stream().map(t -> t.split("")).flatMap(Arrays::stream)
				.mapToInt(value -> value.codePointAt(0)).sum());

		int[] cubed = Arrays.stream(new int[] { 1, 2, 3, 4, 5 }).map(number -> number * number * number).toArray();
		System.out.println(Arrays.toString(cubed));

		Food.foods().stream().filter(food -> food.getCalories() < 500).findAny().ifPresent(System.out::println);

		int[] numbers = { 1, 2, 3, 4 };
		Arrays.stream(numbers).reduce((one, two) -> one + two).ifPresent(System.out::println);
		Arrays.stream(numbers).reduce(0, Integer::sum);

		// number of dishes
		Food.foods().stream().map(food -> 1).reduce(Integer::sum)
				.ifPresent(number -> System.out.println("Number of foods : " + number));
	}
}
