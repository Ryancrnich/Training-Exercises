package com.revature.driver;

import com.revature.q1.BubbleSort;
import com.revature.q2.Fibonacci;
import com.revature.q3.Reverse;
import com.revature.q4.Factorial;
import com.revature.q6.EvenSteven;
import com.revature.q8.Palindrome;
import com.revature.q9.Prime;
import com.revature.q10.Ternary;
import com.revature.q11.FloatGrabber;
import com.revature.q12.EvenMoreArrays;
import com.revature.q13.Triangle;
import com.revature.q14.SwitchItUp;
import com.revature.q15.MathImpl;
import com.revature.q15.MathInterface;
import com.revature.q16.StringLength;
import com.revature.q19.ArrayListFun;


public class Driver {
	
	public static void main(String[] args) {
		System.out.print("1) ");
		/*1*/ BubbleSort.sortBubble(BubbleSort.intArray);
		System.out.println();
		System.out.print("2) ");
		/*2*/ Fibonacci.fibo25();
		System.out.println();
		System.out.print("3) ");
		/*3*/ Reverse.reverseReverse();
		System.out.println();
		System.out.print("4) ");
		/*4*/ Factorial.exclaimationPoint();
		System.out.println();
		System.out.print("5) ");
		/*5*/
		System.out.println();
		System.out.print("6) ");
		/*6*/ EvenSteven.noPercentage();
		System.out.println();
		System.out.print("7) ");
		/*7*/
		System.out.println();
		System.out.print("8) ");
		/*8*/ Palindrome.palinDrome();
		System.out.println();
		System.out.print("9) ");
		/*9*/ Prime.prime();
		System.out.println();
		System.out.print("10) ");
		///*10*/ Ternary.minFind();
		System.out.println();
		System.out.print("11) ");
		/*11*/ FloatGrabber.grabSomeFloats();
		System.out.println();
		System.out.print("12) ");
		/*12*/ EvenMoreArrays.evenArray();
		System.out.println();
		System.out.print("13) ");
		//*13*/ Triangle.makeTheThing();
		System.out.println();
		System.out.print("14) ");
		/*14*/ SwitchItUp.switchTime();
		System.out.println();
		System.out.print("15) ");
		/*15*/MathImpl m = new MathImpl();
			System.out.print("Math Interface/Implimentation: " + m.addition(5, 5));
			System.out.print(" " + m.subtraction(5, 5));
			System.out.print(" " + m.multiplication(5, 5));
			System.out.println(" " + m.division(5, 5));
		System.out.println();
		System.out.print("16) ");
		/*16*/StringLength.howMany();
		System.out.println();
		System.out.print("17) ");
		/*17*/
		System.out.println();
		System.out.print("18) ");
		/*18*/
		System.out.println();
		System.out.print("19) ");
		/*19*/ ArrayListFun.addTo();
		System.out.println();
		System.out.print("20) ");
		/*20*/	
	}

}
