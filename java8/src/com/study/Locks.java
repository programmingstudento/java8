package com.study;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

class Count {
	private int count;
	private Lock lock;

	public Count() {
		lock = new ReentrantLock();
	}

	public void incrementCount() {
		try {
			lock.lock();
			count++;
		} finally {
			lock.unlock();
		}
	}

	public int getCount() {
		return count;
	}
}

public class Locks {

	public static void main(String[] args) {
		Count count = new Count();
		Thread thread1 = new Thread(() -> {
			IntStream.range(0, 10).forEach(num -> count.incrementCount());
		});
		Thread thread2 = new Thread(() -> {
			IntStream.range(0, 10).forEach(num -> count.incrementCount());
		});
		thread1.start();
		thread2.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Count : " + count.getCount());
	}
}
