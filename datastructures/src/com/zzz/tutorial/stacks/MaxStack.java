package com.zzz.tutorial.stacks;

import java.util.Scanner;
import java.util.Stack;

public class MaxStack {
	private static Stack<Integer> input = new Stack<Integer>();
	private static Stack<Integer> max = new Stack<Integer>();

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int option;
		for (int i = 0; i < N; i++) {
			option = in.nextInt();
			switch (option) {
			case 1:
				insert(in.nextInt());
				break;
			case 2:
				pop();
				break;
			case 3:
				max();
				break;
			default:
				System.out.println("Not an option");
			}
		}
	}

	private static void insert(int in) {
		if (max.empty() || max.peek() <= in) {
			max.push(in);
		}
		input.push(in);
	}

	private static void pop() {
		if (input.empty())
			return;
		if (!max.empty() && (input.peek() == max.peek())) {
			max.pop();
		}
		input.pop();
	}

	private static void max() {
		if (max.empty())
			return;
		System.out.println(max.peek());
	}

}
