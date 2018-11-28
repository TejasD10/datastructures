package com.zzz.tutorial.misc.strings;

public class UniqueChars {
	public static void main(String[] args) {
		System.out.println(hasUniqueChars("abcdee"));
	}

	private static boolean hasUniqueChars(String input) {
		if (input == null || input.trim().equals(""))
			return false;
		boolean isUnique = true;
		boolean hist[] = new boolean[128];

		for (int i = 0; i < input.length(); i++) {
			if (hist[input.charAt(i)])
				return false;
			hist[input.charAt(i)] = true;
		}
		return isUnique;
	}
}
