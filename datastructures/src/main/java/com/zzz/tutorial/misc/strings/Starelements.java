package com.zzz.tutorial.misc.strings;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Starelements {
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		int testCases = read.nextInt();
		int input[];
		for (int test = 0; test < testCases; test++) {
			int elems = read.nextInt();
			input = new int[elems];
			for (int i = 0; i < elems; i++) {
				input[i] = read.nextInt();
			}
			printStarAndSuperStar(input);
			System.out.println();
		}
	}

	private static void printStarAndSuperStar(int input[]) {
		int i, j, length = input.length - 1, max = input[length];
		boolean hasMax = true;
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(max);
		for (i = length - 1; i >= 0; i--) {
			if (input[i] > max) {
				max = input[i];
				list.add(input[i]);
				hasMax = true;
			} else if (max == input[i])
				hasMax = false;
		}
		while (!list.isEmpty()) {
			System.out.print(list.pollLast() + " ");
		}
		System.out.println();
		System.out.print(hasMax ? max : "-1");
	}
}
