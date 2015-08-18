package com.java8.concurrency.model;

import java.util.Objects;

public final class Key {
	
	private String name;
	
	private int age;
	
	public Key(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(obj == null) return false;
		
		if(getClass() != obj.getClass()) return false;
		
		final Key key = (Key) obj;
		
		if(!Objects.equals(this.name, key.name)) return false;
		
		if(!Objects.equals(this.age, key.age)) return false;
		
		return true;
		
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.name, this.age);
	}

}
