package com.zzz.tutorial;

public class Bitwise {
	public static void main(String[] args) {
		System.out.println(hasUniqueChars("abcd"));
		
		System.out.println(-8 >> 1);
	}

	private static boolean hasUniqueChars(String input) {
		boolean isUnique = true;
		int check = 0;
		int val = 0;
		for (int i = 0; i < input.length(); i++) {
			val = input.charAt(i) - 'a';
			if ((check & (1 << val)) > 0)
				return false;
			check |= 1 << val;
		}

		return isUnique;
	}
}
