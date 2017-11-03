package com.zzz.tutorial;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TwoChars {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		String input = in.next();
		
		//Unique Chars
		Set<Character> unique = new HashSet<Character>();
		for(int i = 0;i < input.length(); i++){
			unique.add(input.charAt(i));
		}
		
		
		
	}
}
