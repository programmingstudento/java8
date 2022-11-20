package com.study;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
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

		long foodCount = Food.foods().stream().collect(Collectors.counting());
		System.out.println("Food Count : " + foodCount);

		Comparator<Food> fooComparator = Comparator.comparing(Food::getCalories);
		Food.foods().stream().collect(Collectors.maxBy(fooComparator)).ifPresent(System.out::println);

		int totalCalories = Food.foods().stream().collect(Collectors.summingInt(Food::getCalories));
		System.out.println(totalCalories);
		double averageCalories = Food.foods().stream().collect(Collectors.averagingInt(Food::getCalories));
		System.out.println(averageCalories);

		IntSummaryStatistics statistics = Food.foods().stream().collect(Collectors.summarizingInt(Food::getCalories));
		System.out.println(statistics);

		Food.foods().stream().collect(Collectors.minBy(fooComparator)).ifPresent(System.out::println);
		System.out.println(Food.foods().stream().map(Food::getName).collect(Collectors.joining(",")));

		int total1 = Food.foods().stream().collect(Collectors.reducing(0, Food::getCalories, (one, two) -> one + two));
		System.out.println(total1);

		int max1 = Food.foods().stream().collect(Collectors.reducing(0, Food::getCalories, (a, b) -> a < b ? b : a));
		System.out.println(max1);

		Map<Type, List<Food>> types = Food.foods().stream().collect(Collectors.groupingBy(Food::getType));
		System.out.println(types);

		Map<Type, Map<Diet, List<Food>>> ones = Food.foods().stream()
				.collect(Collectors.groupingBy(Food::getType, Collectors.groupingBy(food -> {
					if (food.getCalories() < 400) {
						return Diet.HEALTHY;
					} else if (food.getCalories() < 700) {
						return Diet.OK;
					}
					return Diet.BAD;
				})));
		System.out.println(ones);

		System.out.println(Food.foods().stream().collect(Collectors.groupingBy(Food::getType, Collectors.counting())));

		Map<Type, Optional<Food>> sample = Food.foods().stream()
				.collect(Collectors.groupingBy(Food::getType, Collectors.maxBy(fooComparator)));
		System.out.println(sample);

		Map<Boolean, List<Food>> vegFoods = Food.foods().stream()
				.collect(Collectors.partitioningBy(Food::isVegetarian));
		System.out.println(vegFoods.get(false) + "  " + Boolean.valueOf(true));

	}
}
