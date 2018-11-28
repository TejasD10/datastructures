package com.zzz.tutorial.misc.strings;

public class MaxGaps {
	public static void main(String[] args) {
		// 100101
		// 1000
		// 0001
		// 1111
		// 0000
		int max = -1;
		int count = -1;
		String input = "1000001";
		int i,j;
		for (i = 0; i < input.length(); i++) {
			count = 0;
			if (input.charAt(i) == '1') {
				for (j = i + 1; j < input.length(); j++) {
					if (input.charAt(j) == '1')
						break;
					count++;
				}
				if (count > max && j < input.length())
					max = count;
			}
		}
		System.out.println(max);
	}
}
