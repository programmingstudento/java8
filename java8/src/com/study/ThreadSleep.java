package com.study;

/*
 * A java program in which thread sleep for 2 sec and change the name of the thread.
 */
public class ThreadSleep {

	public static void main(String[] args) throws InterruptedException {
		System.out.println(Thread.currentThread().getName());
		Thread thread = new Thread(() -> {
			System.out.println(Thread.currentThread().getName());
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}, "Thread One");
		thread.start();
		thread.join();
		thread.setName("Thread 1");
		System.out.println(thread.getName());
	}
}
