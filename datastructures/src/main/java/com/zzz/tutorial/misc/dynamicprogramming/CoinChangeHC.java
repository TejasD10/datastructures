package com.zzz.tutorial.misc.dynamicprogramming;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 
 * This is the implementation for the coin change problem from hackerrank Sample
 * Input: 4 {1,2,3} Output: 4;
 */
public class CoinChangeHC {
	public static long makeChange(int[] coins, int money) {
		if (coins.length == 0)
			return 0L;
		if (money == 0)
			return 0L;
		return makeChange(coins, money, 0, new HashMap<String, Long>());
	}

	private static long makeChange(int[] coins, int money, int index, HashMap<String, Long> memo) {
		if (money == 0)
			return 1L;
		if (index >= coins.length)
			return 0L;
		String key = money + "-" + index;
		if (memo.containsKey(key))
			return memo.get(key);
		int i;
		long ways = 0;
		for (i = 0; (i * coins[index]) <= money; i++) {
			ways += makeChange(coins, (money - (i * coins[index])), index + 1, memo);
		}
		memo.put(key, ways);
		return ways;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int coins[] = new int[m];
		for (int coins_i = 0; coins_i < m; coins_i++) {
			coins[coins_i] = in.nextInt();
		}
		System.out.println(makeChange(coins, n));
	}
}
