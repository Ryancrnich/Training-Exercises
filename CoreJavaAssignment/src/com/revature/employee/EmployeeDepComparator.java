package com.revature.employee;

import java.util.Comparator;

public class EmployeeDepComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		// TODO Auto-generated method stub
		return o1.getDepartment().compareTo(o2.getDepartment());
	}

	

}
