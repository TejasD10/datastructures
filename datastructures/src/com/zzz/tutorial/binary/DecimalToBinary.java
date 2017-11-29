package com.zzz.tutorial.binary;

import java.util.Scanner;

import javax.swing.plaf.synth.SynthSeparatorUI;

/**
 * Given a decimal number, 3.72 convert it into Binary, if not possible print
 * "ERROR" on the console
 * 
 *
 */
public class DecimalToBinary {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String input = in.next();

		int intPart = Integer.parseInt(input.substring(0, input.indexOf('.')));
		double decPart = Double.parseDouble(input.substring(input.indexOf('.'), input.length()));

		System.out.println("IntPart: " + intPart);
		System.out.println("DecPart: " + decPart);

		String L = "";
		while (intPart > 0) {
			L = (intPart % 2) + L;
			intPart >>= 1;
		}
		System.out.println("IntPart :" + L);
		String R = "";
		while (decPart > 0) {
			if (R.length() > 32) {
				System.out.println("ERROR");
				return;
			}
			double d = decPart * 2;
			if (d > 1) {
				R += "1";
				decPart = d - 1;
			} else {
				R += "0";
				decPart = d;
			}
		}
		System.out.println("DecPart :" + R);
	}
}
