package com.example;

import javax.swing.JOptionPane;

public class DailogforAdd {
	public static void main(String[] args) {
		String n1 = JOptionPane.showInputDialog("Enter a number");
		String n2 = JOptionPane.showInputDialog("enter second number");
		
		/* or we can use 
		 * int n1 = Integer.parseInt(JOptionPane.showInputDialog("Enter a number"));
		 * int n2 = Integer.parseInt(JOptionPane.showInputDialog("Enter a another number"));
		 * */ 
		
		int a = Integer.parseInt(n1);
		int b = Integer.parseInt(n2);
		JOptionPane.showMessageDialog(null, "the addtion of "+n1+" and "+n2+" is "+(a+b));
		
	}
}
