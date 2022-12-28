package com.core.java;

public class Clerk {
	private String name;
	private int age;

	public Clerk(final String name, final int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return String.format("Clerk [name=%s, age=%s]", name, age);
	}

}
