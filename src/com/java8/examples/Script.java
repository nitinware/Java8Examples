package com.java8.examples;

public interface Script {
	
	public void playScript();
	
	default public void story() {
		System.out.println("Hurray !!! script provided for running the play.");
	}

}
