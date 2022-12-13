package com.core.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TripleSorter {

	public static String sort(final List<Student> students) {
		final List<Student> student = new ArrayList<>(students);
		Collections.sort(student,
				Comparator.comparing(Student::getGpa, (p1, p2) -> p2.compareTo(p1))
						.thenComparing((o1, o2) -> o1.getFullName().split(" ")[1].substring(0, 1)
								.compareTo(o2.getFullName().split(" ")[1].substring(0, 1)))
						.thenComparing(Student::getAge));
		return student.stream().map(Student::getFullName).collect(Collectors.joining(","));
	}

}

class Student {
	int age;
	int gpa;
	String fullName;

	Student(int age, int gpa, String fullName) {
		this.age = age;
		this.gpa = gpa;
		this.fullName = fullName;
	}

	int getAge() {
		return age;
	}

	int getGpa() {
		return gpa;
	}

	String getFullName() {
		return fullName;
	}

};