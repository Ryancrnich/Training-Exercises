package com.revature.io;

import java.util.Scanner;

import com.revature.bean.Person;

public class SerialDemo {
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		IO io = new IO();
		/*
		 * if output.txt does not exist, it will create it!
		 * if doesn't exist, run it, and then refresh the 
		 * project explorer to see it
		 */
//		System.out.println("What would you like to write?");
//		String s  = sc.nextLine();
//		io.writeOutputStreamContents(s);
//		System.out.println(io.readInputStreamContents());
		
//		Person p1 = new Person("Matt", 33, 4000);
//		Person p2 = new Person("Sir James Todd", 75, 15);
//		Person p3 = new Person("Derron", 309, 195);
//		Person p4 = new Person("Drthalie", 1111, 500);
//		IOWithCollections.personList.add(p1);//we have to reference person by class instead of individual object because IOWithCollections is Static
//		IOWithCollections.personList.add(p2);
//		IOWithCollections.personList.add(p3);
//		IOWithCollections.personList.add(p4);
//		IOWithCollections.writePersonFile();
		
		IOWithCollections.readPersonFile();
		System.out.println(IOWithCollections.personList.toString());
	}
	

}