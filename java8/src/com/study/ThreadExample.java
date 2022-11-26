package com.study;

public class ThreadExample {
	private int counter;

	public ThreadExample() {

	}

	public synchronized void increment() {
		this.counter++;
	}

	public synchronized void incrementer() {
		this.counter++;
		increment();
	}

	public int getCounter() {
		return counter;
	}
}
