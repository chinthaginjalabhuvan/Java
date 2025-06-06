package com.example;

public class Calculator {   // local variable example
	
	void square(int x) {   // void does not return
		int result = x*x;
		System.out.println("square is "+result);
	}
	
	static void add(int x,int y) {
		System.out.println("the addition of "+x+" and "+y+" is "+(x+y));
	}
	
	
	int cube(int x) {    // int has to be return
		return (x*x*x);
	}

	public static void main(String[] args) {
		Calculator c = new Calculator();
		c.square(5);
		add(22,33);
		int output = c.cube(5);
		System.out.println(output);
		

	}

}
