package com.revature.employe;

public class Employe {
	public String name;
	public String department;
	public int age;
	
	
	
	public Employe() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Employe(String name, String department, int age) {
		super();
		this.name = name;
		this.department = department;
		this.age = age;
	}
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	@Override
	public String toString() {
		return "Employe [name=" + name + ", department=" + department + ", age=" + age + "]";
	}
	
	

}