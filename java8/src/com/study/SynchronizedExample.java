package com.study;

public class SynchronizedExample {
	private String name;

	public SynchronizedExample() {

	}

	public synchronized void setName(String name) {
		System.out.println(Thread.currentThread().getName());
		this.name = name;
	}

	public synchronized void setNamee(String name) {
		synchronized (this) {
			this.name = name;
		}
	}

	public synchronized String getName() {
		return name;
	}

	public synchronized String getNames() {
		synchronized (this) {
			return name;
		}
	}
}
