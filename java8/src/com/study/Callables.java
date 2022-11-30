package com.study;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Callables {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(1);
		Future<String> one = executorService.submit(getCallable("First"));
		String result = null;
		try {
			result = one.get();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		System.out.println(one.isDone());
		if (result != null) {
			System.out.println(result);
		}
		executorService.shutdown();
	}

	public static Callable<String> getCallable(String name) {
		return () -> Thread.currentThread().getName() + " " + name;
	}
}
