package com.zzz.tutorial;


/**
 * 
 * Replace the characters in o(n+m)
 * n = length of input
 * m = length of to be removed string
 *
 */
		
public class RemoveSpecifiedChars {
	public static void main(String[] args) {
		System.out.println(removeChars("Battle of Vowels".toCharArray(), "aeiou".toCharArray()));

	}

	private static String removeChars(char[] input, char[] remove) {
		int src = 0, dst = 0;
		boolean hist[] = new boolean[128];

		for (int i = 0; i < remove.length; i++) {
			hist[remove[i]] = true;
		}
		for (int i = 0; i < input.length; i++) {
			if (!hist[input[i]]) {
				input[dst++] = input[i];
			}
		}
		return new String(input, 0, dst);

	}
}
