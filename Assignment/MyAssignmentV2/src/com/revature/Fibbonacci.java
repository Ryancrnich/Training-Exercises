package com.revature;

public class Fibbonacci {

	int maxNumber = 25;
    int previousNumber = 0;
    int nextNumber=1;
	int i =1;
	

    						
    public int[] fibbonacci(){
    	int arr[] = {};
    	System.out.print("Fibonacci Series of "+maxNumber+" numbers:");
    	while(i <= maxNumber)

    	{
    		System.out.print(previousNumber+" ");
    		int sum = previousNumber + nextNumber;
    		previousNumber = nextNumber;
    		nextNumber = sum;
    		i++;
    	}
    	
    	
    	System.out.println(" ");
    	for(int i = 0; i < arr.length; i++) {
	  		System.out.print(arr[i] + " ");
	  	}
		return arr ;
    }


}
