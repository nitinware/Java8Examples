package com.java8.concurrency.examples;

import java.util.concurrent.TimeUnit;

public class RunnableDemo {

	public static void main(String[] args) {
		
		Runnable task = () -> {
			try {
				String threadName = Thread.currentThread().getName();
				System.out.println("Foo " + threadName);
				TimeUnit.SECONDS.sleep(1);
				System.out.println("Bar " + threadName);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			};
		
		task.run();
		
		Thread thread = new Thread(task);
		thread.start();
		
		System.out.println("Done!!!");
		
	}

}
