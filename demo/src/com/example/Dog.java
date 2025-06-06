package com.example;

public class Dog {
	int legs = 6;
	void eat() {
		System.out.println("eat bones");
	}
	
	public static void main(String[] args) {
		Dog d = new Dog();
		d.eat();
		System.out.println("dog has "+d.legs+" legs");
	}
}
