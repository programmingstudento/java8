package com.core.java;

public class Person {
	private int age;
	private Classification classification;

	public Person(final int age, final Classification classification) {
		this.age = age;
		this.classification = classification;
	}

	public int getAge() {
		return age;
	}

	public Classification getClassification() {
		return classification;
	}

	@Override
	public String toString() {
		return String.format("Person [age=%s, classification=%s]", age, classification);
	}
}
