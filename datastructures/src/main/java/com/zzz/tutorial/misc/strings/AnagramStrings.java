package com.zzz.tutorial.misc.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AnagramStrings {
	public static int numberNeeded(String first, String second) {

		if (first == null || second == null || first.trim().equals("") || second.trim().equals("")) {
			return 0;
		}
		Map<Character, Integer> histo1 = new HashMap<Character, Integer>();
		Map<Character, Integer> histo2 = new HashMap<Character, Integer>();
		int count = 0, dels = 0;
		// Count in the first string
		for (int i = 0; i < first.length(); i++) {
			if (histo1.get(first.charAt(i)) == null) {
				histo1.put(first.charAt(i), 1);
			} else {
				histo1.put(first.charAt(i), histo1.get(first.charAt(i)) + 1);
			}
		}
		// Count in the second string
		for (int i = 0; i < second.length(); i++) {
			if (histo2.get(second.charAt(i)) == null) {
				histo2.put(second.charAt(i), 1);
			} else {
				histo2.put(second.charAt(i), histo2.get(second.charAt(i)) + 1);
			}
		}
		for (Map.Entry<Character, Integer> entry : histo1.entrySet()) {
			if (histo2.get(entry.getKey()) == null) {
				dels += entry.getValue();
			}
		}
		for (Map.Entry<Character, Integer> entry : histo2.entrySet()) {
			if (histo1.get(entry.getKey()) == null) {
				dels += entry.getValue();
				continue;
			}
			if (entry.getValue() != histo1.get(entry.getKey())) {
				dels += Math.abs(entry.getValue() - histo1.get(entry.getKey()));
			}
		}

		return dels;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String a = in.next();
		String b = in.next();
		System.out.println(numberNeeded(a, b));
	}
}
