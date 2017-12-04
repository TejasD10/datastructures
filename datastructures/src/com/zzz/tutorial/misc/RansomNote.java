package com.zzz.tutorial.misc;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class RansomNote {
	Map<String, Integer> magazineMap;
	Map<String, Integer> noteMap;

	public RansomNote(String magazine, String note) {

		// Fill the map with each word and their counts from magazine.
		magazineMap = new HashMap<String, Integer>();
		fillMap(magazine, magazineMap);
		noteMap = new HashMap<String, Integer>();
		fillMap(note, noteMap);
	}

	private void fillMap(String input, Map<String, Integer> map) {
		if (input == null) {
			return;
		}
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == ' ') {
				map.put(sb.toString(), map.get(sb.toString()) == null ? 1 : map.get(sb.toString()) + 1);
				sb = sb.delete(0, sb.length());
			} else
				sb.append(input.charAt(i));
			if ((i + 1) == input.length())
				map.put(sb.toString(), map.get(sb.toString()) == null ? 1 : map.get(sb.toString()) + 1);
		}
	}

	public boolean solve() {
		if (magazineMap.isEmpty() || noteMap.isEmpty())
			return false;
		for (Entry<String, Integer> entry : noteMap.entrySet()) {
			if (!magazineMap.containsKey(entry.getKey()))
				return false;
			int magCount = magazineMap.get(entry.getKey());
			if (magCount < entry.getValue())
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int m = scanner.nextInt();
		int n = scanner.nextInt();

		// Eat whitespace to beginning of next line
		scanner.nextLine();

		RansomNote s = new RansomNote(scanner.nextLine(), scanner.nextLine());
		scanner.close();

		boolean answer = s.solve();
		if (answer)
			System.out.println("Yes");
		else
			System.out.println("No");

	}

}
