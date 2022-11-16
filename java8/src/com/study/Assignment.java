package com.study;

import java.util.Arrays;
import java.util.List;

public class Assignment {

	public static void main(String[] args) {
		Merchant one = new Merchant("Rina", "Biratnagar");
		Merchant two = new Merchant("Dina", "Dharan");
		Merchant three = new Merchant("Shital", "Biratnagar");
		Merchant four = new Merchant("Sarita", "Biratnagar");

		List<Business> business = Arrays.asList(new Business(four, 2011, 300), new Business(one, 2012, 1000),
				new Business(one, 2011, 400), new Business(two, 2012, 710), new Business(two, 2012, 700),
				new Business(three, 2012, 950));

		// business in 2011 and sort by value (high to small)
		business.stream().filter(t -> t.getYear() == 2011)
				.sorted((o1, o2) -> -1 * Integer.compare(o1.getValue(), o2.getValue())).forEach(System.out::println);

		// unique cities
		business.stream().map(b -> b.getMerchant().getCity()).distinct().forEach(System.out::println);

		// merchants from Biratnagar and sort them by name.
		business.stream().filter(b -> b.getMerchant().getCity().equals("Biratnagar"))
				.sorted((o1, o2) -> o1.getMerchant().getName().compareTo(o2.getMerchant().getName()))
				.map(Business::getMerchant).distinct().forEach(System.out::println);
		// name of all traders sorted alphabetically
		String word = business.stream().map(b -> b.getMerchant().getName()).distinct().sorted().reduce("",
				(x, y) -> x.concat(":" + y));
		System.out.println(word.substring(1));
		// merchants available in dharan
		business.stream().filter(b -> b.getMerchant().getCity().equals("Dharan")).findAny()
				.ifPresent(System.out::println);
		// displaying all business values from Biratnagar
		business.stream().filter(b -> b.getMerchant().getCity().equals("Biratnagar"))
				.forEach(b -> System.out.println(b.getValue()));
		// highest value of all business
		int highestValue = business.stream().map(Business::getValue).reduce(0, (a, b) -> a < b ? b : a);
		System.out.println("Highest value : " + highestValue);
		business.stream().map(Business::getValue).sorted((o1, o2) -> -1 * o1.compareTo(o2)).findFirst()
				.ifPresent(n -> System.out.println("Highest Value : " + n));
		business.stream().map(Business::getValue).sorted((o1, o2) -> -1 * o1.compareTo(o2)).limit(1)
				.forEach(n -> System.out.println("Highest Value : " + n));

		// lowest value in business
		int lowestValue = business.stream().map(Business::getValue).reduce(Integer.MAX_VALUE, Integer::min);
		System.out.println("Lowest value : " + lowestValue);
	}
}