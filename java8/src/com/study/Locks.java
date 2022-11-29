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

		Calculator calculator1 = new Calculator(51, Operation.ADDITION),
				calculator2 = new Calculator(51, Operation.SUBTRACTION),
				calculator3 = new Calculator(51, Operation.MULTIPLICATION),
				calculator4 = new Calculator(511, Operation.DIVISION);

		Calculator[] one = { calculator1, calculator2, calculator3, calculator4 };
		Thread thread3 = new Thread(() -> {
			calculator1.calculate(one);
		});
		Thread thread4 = new Thread(() -> {
			calculator1.calculate(one);
		});
		thread3.start();
		thread4.start();
	}
}
