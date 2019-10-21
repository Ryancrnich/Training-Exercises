package com.revature.exercises;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Q20 {
	public static List<String> doTheThing() {
		List<String> bits = new ArrayList<String>();
		try {
			BufferedReader br = new BufferedReader(new FileReader("Data.txt"));

			String currentLine = br.readLine();
			String[] segments = currentLine.split(":");
			String loopVar = "";

			for (int i = 1; i < segments.length; i++) {
				if (i == 1) {
					loopVar = "Name: ";
					loopVar += segments[i - 1] + " " + segments[i];
				} else {
					if (i == 2)
						loopVar = "Age: ";
					if (i == 3)
						loopVar = "State: ";
					loopVar += segments[i];
				}
				System.out.println(loopVar);
				bits.add(loopVar);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bits;
	}
}
