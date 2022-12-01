package com.study;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class ExampleOne {

	public static void main(String[] args) {
		CountOne countOne = new CountOne();
		Thread thread1 = new Thread(() -> IntStream.range(0, 100).forEach(n -> countOne.increment()));
		Thread thread2 = new Thread(() -> IntStream.range(0, 100).forEach(n -> countOne.decrement()));
		thread1.start();
		thread2.start();
		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(countOne.getCounter());
	}

}

class CountOne {
	private int counter;
	private Lock lock = new ReentrantLock();

	public void increment() {
		try {
			lock.lock();
			counter += 2;
		} finally {
			lock.unlock();
		}
	}

	public void decrement() {
		try {
			lock.lock();
			counter--;
		} finally {
			lock.unlock();
		}
	}

	public int getCounter() {
		return counter;
	}
}