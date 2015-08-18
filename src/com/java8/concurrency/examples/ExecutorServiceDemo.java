package com.java8.concurrency.examples;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceDemo {

	public static void main(String[] args) {
		
		try {
			ExecutorService service = Executors.newSingleThreadExecutor();
			service.submit(() -> {
				String name = Thread.currentThread().getName();
				System.out.println("Hello - " + name);
				});
			service.shutdown();
			service.awaitTermination(5, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
