package com.zzz.tutorial.misc;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Davis has staircases in his house and he likes to climb each staircase 1, 2
 * or 3 steps at a time. Being a very precocious child, he wonders how many ways
 * there are to reach the top of the staircase.
 * 
 * Given the respective heights for each of the staircases in his house, find
 * and print the number of ways he can climb each staircase on a new line.
 * 
 *
 */
public class DavidStaircase {

	private static Map<Integer, Integer> map = new HashMap<Integer, Integer>();

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int s = in.nextInt();
		for (int a0 = 0; a0 < s; a0++) {
			int n = in.nextInt();
			System.out.println(climbStairs(n, 0));
		}
	}

	private static int climbStairs(int steps, int stepCount) {
		if (stepCount > steps || steps < 0)
			return 0;

		steps -= stepCount;

		if (steps == 0)
			return 1;
		int ways = 0;
		if (!map.containsKey(steps)) {
			for (int i = 1; i < 4; i++) {
				if (i <= steps) {
					ways += climbStairs(steps, i);
					map.put(steps, ways);
				}
			}
		}
		return map.get(steps);
	}
}
