package com.example;

public class Ex {
	public static void main(String[] args) { 
		System.out.println(args[0]);
		System.out.println(args[1]);
		Dog.main(null); // we are calling Dog class main method in this class main method
		
	}
}
