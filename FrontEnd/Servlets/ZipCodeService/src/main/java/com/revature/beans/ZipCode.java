package com.revature.beans;

public class ZipCode {
	private int zipCode;
	private String city;
	private String state;
	public ZipCode() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ZipCode(int zipCode, String city, String state) {
		super();
		this.zipCode = zipCode;
		this.city = city;
		this.state = state;
	}
	public int getZipCode() {
		return zipCode;
	}
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "ZipCode [zipCode=" + zipCode + ", city=" + city + ", state=" + state + "]";
	}
	
	
}