package com.study;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {

	public static void main(String[] args) {
		Work work1 = new Work();
		Thread thread1 = new Thread(work1, "Thread 1 "), thread2 = new Thread(work1, "Thread 2 "),
				thread3 = new Thread(work1, "Thread 3 ");
		thread1.start();
		thread2.start();
		thread3.start();

	}

}

class Work implements Runnable {

	private Semaphore semaphore = new Semaphore(1);

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " : ");
		try {
			semaphore.acquire();
			for (int count = 0; count < 3; count++) {
				System.out.println("Running Count : " + count + " " + Thread.currentThread().getName());
				Thread.sleep(500);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaphore.release();
		}
	}

}