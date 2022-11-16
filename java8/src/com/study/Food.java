package com.study;

import java.util.Arrays;
import java.util.List;

public class Food {

	private String name;
	private boolean isVegetarian;
	private int calories;
	private Type type;

	public Food(String name, boolean isVegetarian, int calories, Type type) {
		this.name = name;
		this.isVegetarian = isVegetarian;
		this.calories = calories;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public boolean isVegetarian() {
		return isVegetarian;
	}

	public int getCalories() {
		return calories;
	}

	public Type getType() {
		return type;
	}

	public static List<Food> foods() {
		return Arrays.asList(new Food("chicken chilly", false, 800, Type.CHICKEN),
				new Food("mutton biryani", false, 700, Type.MUTTON),
				new Food("chicken pasta", false, 400, Type.CHICKEN), new Food("potato chips", true, 530, Type.OTHER),
				new Food("rice", true, 350, Type.OTHER), new Food("banana", true, 120, Type.OTHER),
				new Food("cookie", true, 550, Type.OTHER), new Food("fish", false, 400, Type.FISH),
				new Food("salmon", false, 450, Type.FISH));
	}

	@Override
	public String toString() {
		return String.format("Food [name=%s, isVegetarian=%s, calories=%s, type=%s]", name, isVegetarian, calories,
				type);
	}

}
