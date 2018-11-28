package com.zzz.tutorial.stacks;

import java.util.Scanner;
import java.util.Stack;

public class MatchingBrackets {

	static String isBalanced(String s) {
		if (s == null || s.trim().equals(""))
			return "NO";
		String left = "([{";
		String right = ")]}";
		Stack<Character> input = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			if (left.indexOf(s.charAt(i)) != -1)
				input.push(s.charAt(i));
			if (right.indexOf(s.charAt(i)) != -1) {
				if (input == null || input.isEmpty())
					return "NO";
				switch (s.charAt(i)) {
				case ')':
					if (input.peek() == '(') {
						input.pop();
						break;
					}
					return "NO";
				case ']':
					if (input.peek() == '[') {
						input.pop();
						break;
					}
					return "NO";
				case '}':
					if (input.peek() == '{') {
						input.pop();
						break;
					}
					return "NO";
				}

			}
		}
		if (input.empty())
			return "YES";
		return "NO";
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			String s = in.next();
			String result = isBalanced(s);
			System.out.println(result);
		}
		in.close();
	}
}
