package com.revature.q12;

public class EvenMoreArrays {

	public static int [] myArray = new int[100]; 
	
	public static void evenArray() {
		System.out.print("Array of Even Numbers: [");
		for (int i = 0; i < myArray.length; i++) {
		    myArray[i] = i + 1;
		    if(myArray[i]%2==0) {
		    	if (i != 99) {
		    		System.out.print(myArray[i] + ", ");
		    	}
		    	else {
		    		System.out.print(myArray[i]);
		    	}
		    }
		}
		System.out.println("]");
	}
}