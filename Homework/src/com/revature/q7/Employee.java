package com.revature.q7;

public class Employee {
	
	private String name;
	private String department;
	private Integer age;
	
	
	
	public Employee(String name, String department, Integer age) {
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
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Employee [name=" + name + ", department=" + department + ", age=" + age + "]";
	}
	
	
	

}
