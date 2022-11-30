package com.study;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServices {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		executorService.execute(getRunnable("One"));
		executorService.execute(getRunnable("Two"));
		executorService.execute(getRunnable("Three"));
		executorService.shutdown();
	}

	public static Runnable getRunnable(String name) {
		return () -> System.out.println(name + " running.");
	}
}
