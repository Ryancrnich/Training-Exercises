package com.revature.homework;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
/******************************************************************************
 * 
 * Q11.  Write a program that would access two float-variables from a class that
 *  	 exists in another package. Note, you will need to create two packages 
 *  	 to demonstrate the solution.
 *  
 * @author Bryan Wood
 *
 *****************************************************************************/
class Question11Test {

	@Test
	void test() {
		float[] answer = {2342534,12342};
		Question11 q = new Question11();
		assertArrayEquals(answer,q.getFloat());
	}

}