package com.githubauto.webdriver;

import java.util.Arrays;
import java.util.List;

public class HelloWorld {

	public static void main(String[] args) {
		System.out.println("Hello World");
		
		int x = 0;
		
		if ( x == 0) {
			throw new RuntimeException("Wrong x value");
		}
		
		try {
			printList();
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new RuntimeException("Error occured");
			//System.out.println("You are reading outofbound values");
		}
		System.out.println("I am done!");
	}
// privite function
	private static void printList() {
		List<String> names = Arrays.asList("one", "two");
		System.out.println(names);
		names.get(3); // Error is created. 
		System.out.println("after reading value");
	}
}
