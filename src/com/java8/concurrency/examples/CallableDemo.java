package com.java8.concurrency.examples;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class CallableDemo {

	public static void main(String[] args) {

		try {

			Callable<Integer> task = () -> {
				TimeUnit.SECONDS.sleep(1);
				return 123;
			};

			ExecutorService service = Executors.newFixedThreadPool(1);

			Future<Integer> future = service.submit(task);

			System.out.println("future done? " + future.isDone());

			Integer result = future.get();

			System.out.println("future done? " + future.isDone());
			System.out.println("result: " + result);
			
			service.shutdown();

		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}

}
