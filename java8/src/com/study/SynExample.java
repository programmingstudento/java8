package com.study;

import java.util.stream.IntStream;

public class SynExample {

	public static void main(String[] args) {
		SynchronizedExample example1 = new SynchronizedExample();
		Thread thread1 = new Thread(() -> {
			IntStream.range(0, 5).forEach(number -> example1.setName("SQL " + number));
		}, "One");

		Thread thread2 = new Thread(() -> {
			IntStream.range(0, 50).forEach(number -> System.out.println(example1.getNames()));
		});

		Thread thread3 = new Thread(() -> {
			IntStream.range(0, 5).forEach(number -> example1.setName("SQL " + number));
		},"Two");

		thread1.start();
		thread2.start();
		thread3.start();
	}
}
