package com.zzz.tutorial.misc;

import java.util.Scanner;

public class SingleSwapMinNumber {
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		int tc = read.nextInt();
		for (int test = 0; test < tc; test++) {
			String input = read.next();
			minSwap(input);
			System.out.println();
		}
	}

	private static void minSwap(String input) {
		//char charInput[] = String.valueOf(input).toCharArray();
		char charInput[] =input.toCharArray();
		int min = 0;

		for (int i = 1; i < charInput.length; i++) {
			if (charInput[i] < charInput[min] && charInput[i] != '0')
				min = i;
		}
		if (charInput[min] != charInput[0]) {
			char temp = charInput[min];
			charInput[min] = charInput[0];
			charInput[0] = temp;
		}
		System.out.print(charInput);
	}
}
