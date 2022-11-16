package com.study;

import java.util.List;
import java.util.stream.Collectors;

public class FoodTester {

	public static void main(String[] args) {
		// Three highest calorie food names
		List<String> foods = Food.foods().stream()
				.sorted((o1, o2) -> Integer.compare(o2.getCalories(), o1.getCalories())).limit(3)
				.map(food -> food.getName().concat(" " + food.getCalories())).collect(Collectors.toList());
		System.out.println(foods);

	}
}
