package com.zzz.tutorial.misc;

public class WordCount {
	public static void main(String[] args) {
		System.out.println(wordCount("  Hello   World  there  "));
	}

	public static int wordCount(String str) {
		//If the string is null, return 0
		if (str == null || str.trim().equals("")) {
			return 0;
		}
		boolean wordStarted = false;
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ' && !wordStarted) // checks for leading spaces in the sentence
				continue;
			if (str.charAt(i) != ' ') // Mark the first word in the sentence started
				wordStarted = true;
			// Real word found, need to increment the count after all the spaces are encountered.
			if (wordStarted && str.charAt(i) == ' ') { 
				do {
					i++;
				} while (i < str.length() && str.charAt(i) == ' ');
				count++;
			}
			//If there are no trailing spaces, the last word needs to be counted.
			if(i + 1 == str.length())
				count++;
		}
		return count;
	}
}
