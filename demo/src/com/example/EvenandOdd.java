package com.example;

import javax.swing.JOptionPane;

public class EvenandOdd {
	public static void main(String[] args) {
		int n = Integer.parseInt(JOptionPane.showInputDialog("Enter a number"));
		if(n%2 == 0) {
			JOptionPane.showMessageDialog(null, "it is a even number");
		}else {
			JOptionPane.showMessageDialog(null, "it is not even number");
		}
	}
}
