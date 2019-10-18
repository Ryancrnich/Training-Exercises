package com.revature.generics;

public class GenDemo {
	public static void main(String[] args) {
		//create a gen! Reference for integers
		Gen1<Integer> i;
		i= new Gen1<Integer>(88);
		i.showType();
		//get value of i
		int v = i.getOb();
		System.out.println("value: " + v);
		
		
		Gen1<String> s = new Gen1<String>("Generics Test");
		s.showType();
		String str = s.getOb();
		System.out.println("value: " + str);
	}
}

