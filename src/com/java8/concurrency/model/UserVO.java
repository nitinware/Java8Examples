package com.java8.concurrency.model;

public class UserVO {
	
	private String name;
	
	private String address;
	
	private String occupation;
	
	private int expYrs;
	
	public UserVO(String name, String address, String occupation, int expYrs) {
		this.name = name;
		this.address = address;
		this.occupation = occupation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public int getExpYrs() {
		return expYrs;
	}

	public void setExpYrs(int expYrs) {
		this.expYrs = expYrs;
	}

}
