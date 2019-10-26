package com.revature.q19;

import java.util.ArrayList;
import java.util.List;

public class ArrayListFun {

	public static List<Integer> myArrayList = new ArrayList<Integer>();
	
	public static void addTo() {
		for (int i = 1; i <= 10; i++) {
			myArrayList.add(i);
		}
		System.out.println("My ArrayList: " + myArrayList.toString());
		addEvensAndOdds();
	}
	
	public static void addEvensAndOdds() {
		int evensSum = 0;
		int oddsSum = 0;
		for (int i = 0; i < 10; i++) {
			if ((myArrayList.get(i) % 2) == 0) {
				evensSum = evensSum + myArrayList.get(i);	
			}
			else if ((myArrayList.get(i) % 2) != 0) {
				oddsSum = oddsSum + myArrayList.get(i);	
			}
		}
		System.out.println("\tSum of Evens: " + evensSum);
		System.out.println("\tSum of Odds: " + oddsSum);
		removePrimes();
	}
	
	public static void removePrimes() {
		ArrayList<Integer> primes = new ArrayList<Integer>();
		for (int i = 1; i <= myArrayList.size(); i++) { 		  	  
	        boolean check = false;
	        for(int j = 2; j <= i/2; j++) {
	            if(i % j == 0)
	            {
	                check = true;
	                break;
	            }
	        }
	        if (!check) {
	        	primes.add(i);
	        }
	    }
		for (int i = 0; i < myArrayList.size(); i++) {
			for (int j = 0; j < primes.size(); j++) {
				if(myArrayList.get(i) == primes.get(j)) {
					myArrayList.remove(i);
				}
			}
		}
		System.out.println("\tMy ArrayList Without Prime Numbers: " + myArrayList.toString());
	}
	
}
