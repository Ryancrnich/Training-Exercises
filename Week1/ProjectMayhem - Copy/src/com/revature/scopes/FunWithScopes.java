package com.revature.scopes;

import com.revature.bean.Person;

public class FunWithScopes {
	{//c is block scope
		int c=4;
		System.out.println(c);
	}
	
	
	//b is static/class scope, exists within this class 
	//(all object of this type)	
	static int b=7;
	public static void main(String[] args) {
		//a is method scope, only exists in THIS method
		int a=3;
		//System.out.println(c);
		Person p= new Person("John", 10000,500);
		//Instance method
		p.getName();
		Person.staticMethod();
		Person.homePlanet="Mars";
		System.out.println(p.homePlanet);
	}
	public static void test() {
		if(b==7) {
			int d=8;
			System.out.println(b);
		System.out.println(d);
		}
		
	}
}