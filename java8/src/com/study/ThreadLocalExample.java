package com.study;

public class ThreadLocalExample {

	public static void main(String[] args) {
		ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

		Thread thread1 = new Thread(() -> {
			threadLocal.set(1);
			System.out.println(threadLocal.get());
		});
		Thread thread2 = new Thread(() -> {
			threadLocal.set(2);
			System.out.println(threadLocal.get());
		});
		thread1.start();
		thread2.start();
	}

}
