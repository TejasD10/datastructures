package com.zzz.tutorial.misc;

// @formatter:off
/**
 * Given an input n, print the permutations of different parenthesis
 * e.g. input = 2, print ()(), (())
 *
 */
//@formatter:on
public class PrintParenthesis {
	public static void main(String[] args) {
		printParens(2);
	}

	private static void printParens(int input) {
		char[] str = new char[1 << input];
		parenHelper(str, input, input, 0);
	}

	private static void parenHelper(char str[], int l, int r, int count) {

		if (/*(l > 0 && r == 0) ||*/ l > r)
			return;
		if (l == 0 && r == 0) {
			System.out.println(str);
		} else {
			if (l > 0) {
				str[count] = '(';
				parenHelper(str, l - 1, r, count + 1);
			}
			if (r > 0) {
				str[count] = ')';
				parenHelper(str, l, r - 1, count + 1);

			}
		}

	}

}
