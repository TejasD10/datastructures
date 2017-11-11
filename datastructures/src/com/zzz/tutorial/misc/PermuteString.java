package com.zzz.tutorial.misc;

/**
 * Given an input string, permute the string and print all the posibilities
 * Backtracking problem, where you choose and unchosse stuff (Basically making
 * choices and returning back to try other choices.
 * 
 *
 */
public class PermuteString {

	public static void main(String[] args) {
		permute(new StringBuilder("ABCD"));
	}

	public static void permute(StringBuilder s) {
		permuter(s, new StringBuilder(""));
	}

	private static void permuter(StringBuilder s, StringBuilder chosen) {
		if (s.length() == 0) {
			System.out.println(chosen);
		} else {
			// choose the first character
			for (int i = 0; i < s.length(); i++) {
				chosen.append(s.charAt(i));
				s.deleteCharAt(i);

				// Permute for the rest of the string
				permuter(s, chosen);

				// Unchoose
				s.insert(i, chosen.charAt(chosen.length() - 1));
				chosen.deleteCharAt(chosen.length() - 1);

			}
		}
	}
}
