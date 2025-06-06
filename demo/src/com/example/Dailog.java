package com.example;
import javax.swing.*;
public class Dailog {
	public static void main(String[] args) {
		String name = JOptionPane.showInputDialog("Enter your name");
		JOptionPane.showMessageDialog(null,"Hi "+ name + " welcome ");
	}
}
