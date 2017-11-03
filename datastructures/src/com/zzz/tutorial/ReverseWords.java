package com.zzz.tutorial;

public class ReverseWords {
	public static void main(String[] args) {
		System.out.println(reverseWords("Is the or not ".toCharArray()));
	}

	private static String reverseWords(char[] input) {
		if (input.length < 1)
			return null;
		int len = input.length - 1;
		int startPos = 0, writePos = 0, readPos = len;
		char[] temp = new char[input.length];

		while (len >= 0) {
			if (input[len] == ' ') {
				temp[writePos++] = input[len--];
			} else {
				startPos = len;
				while (startPos >= 0 && input[startPos] != ' ') {
					startPos--;
				}
				for (int i = startPos + 1; i <= len; i++) {
					temp[writePos++] = input[i];
				}
				len = startPos;
			}
		}

		return new String(temp);
	}
}
