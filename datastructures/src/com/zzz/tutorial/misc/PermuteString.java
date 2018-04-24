package com.zzz.tutorial.misc;

import java.util.ArrayList;

/**
 * Given an input string, permute the string and print all the possibilities
 * Backtracking problem, where you choose and unchosse stuff (Basically making
 * choices and returning back to try other choices.
 * 
 *
 */
public class PermuteString {

	public static void main(String[] args) {
		//permute(new StringBuilder("ABCD"));
		
		//Using ArrayLists
		ArrayList<String> result = getPerms("abc");
		System.out.println(result);
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

	private static ArrayList<String> getPerms(String s) {
		ArrayList<String> perms = new ArrayList<String>();

		if (s == null)
			return perms;
		else if (s.length() == 0) {
			perms.add("");
			return perms;
		} else {
			char first = s.charAt(0);
			String rem = s.substring(1);
			ArrayList<String> words = getPerms(rem);

			for (String word : words) {
				for (int j = 0; j <= word.length(); j++) {
					perms.add(insertCharAt(word, first, j));
				}
			}
		}
		return perms;
	}

	private static String insertCharAt(String word, char first, int j) {
		String left = word.substring(0, j);
		String right = word.substring(j);
		return left + first + right;
	}
}
