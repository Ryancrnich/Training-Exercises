package com.revature.q1;

import java.util.Arrays;

public class BubbleSort {
	
	public float FloatGrabber1 = 313;
	public float FloatGrabber2 = 727;
	
	public static int[] intArray = {1, 0, 5 ,6, 3, 2, 3, 7, 9, 8, 4};

	public static void sortBubble(int[] x) {
		int temp = 0;
		int counter = 0;
		for(int i = 1; i < x.length; i++) {
			for(int j = 0; j < x.length-1;j++) {
				if(x[j] > x[j+1]) {
					counter++;
					temp = x[j];
					x[j] = x[j+1];
					x[j+1] = temp;
				}
			}
			if(counter == 0) {
				break;
			}
		}
		System.out.println("Bubble Sorting: " + Arrays.toString(x));
	}
}
