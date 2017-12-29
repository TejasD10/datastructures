package com.zzz.tutorial.misc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * 
 * 6 
 * 5 
 * 3 4 5 3 2
 *
 */
public class IceCreamParlor {
	/*static void solve(int[] arr, int money) {
		int result = 0;
		for (int i = 0; i < arr.length; i++) {
			Arrays.sort(arr);
			result = Arrays.binarySearch(arr, (money - arr[i]));
			if (result >= 0) {
				System.out.println((i + 1) + " " + (result + 1));
				break;
			}
		}
	}*/
	
	static void solve(int[] arr, int money) {
		Set<Integer> comps = new HashSet<Integer>();
		int i;

		for (i = 0; i < arr.length; i++) {
			if (comps.contains(arr[i])) {
				for (int j = 0; j < i; j++) {
					if (arr[j] == (money - arr[i])){
						System.out.print((j + 1) + " " + (i + 1));
						break;
					}
				}
				
				break;
			} else {
				comps.add(money - arr[i]);
			}
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			int money = in.nextInt();
			int n = in.nextInt();
			int[] arr = new int[n];
			for (int arr_i = 0; arr_i < n; arr_i++) {
				arr[arr_i] = in.nextInt();
			}
			solve(arr, money);
		}
		in.close();
	}
}
