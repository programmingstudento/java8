package com.study;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableExame {

	public static void main(String[] args) {
		Callable<String> callable = () -> "Java,Sql,Javascript,Typescript,Python";
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		Future<String> future = executorService.submit(callable);
		try {
			System.out.println(future.get());
		} catch (InterruptedException | ExecutionException e1) {
			e1.printStackTrace();
		}
		executorService.shutdown();
	}
}
