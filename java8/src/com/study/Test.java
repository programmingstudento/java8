package com.study;

public class Test {

	public static void main(String[] args) {
		ThreadExample example = new ThreadExample();

		Thread thread = new Thread(() -> {
			example.increment();
			example.incrementer();
		});
		thread.start();
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(example.getCounter());
	}

}
