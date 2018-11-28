package com.zzz.tutorial.misc.dynamicprogramming;

// @formatter:off
/**
 * Given an input of N cents, represent the different ways it can represented using
 * 25, 10, 5 and 1 cent denominations respectively.
 *
 */
// @formatter:on
public class ChangeMaker {
	public static void main(String[] args) {
		 //System.out.println(makeChange(25, 0, 0, 0, 0));
		 System.out.println(makeChange(10, 25));
	}

	//@formatter:off
	/*private static int makeChange(int N, int tf, int ten, int five, int one) {
		if (N == 0) {

			System.out.println(tf + " x 25");
			System.out.println(ten + " x 10");
			System.out.println(five + " x 5");
			System.out.println(one + " x 1");
			System.out.println("=============================");

			return 1;
		}
		int ways = 0;
		if (N >= 25)
			ways += makeChange(N - 25, tf + 1, ten, five, one);
		if (N >= 10)
			ways += makeChange(N - 10, tf, ten + 1, five, one);
		if (N >= 5)
			ways += makeChange(N - 5, tf, ten, five + 1, one);
		if (N >= 1) {
			return ways + 1;
		}
			
		return ways;
	}*/
	//@formatter:on
	private static int makeChange(int N, int denom) {

		int next_denom = 0;

		switch (denom) {
		case 25:
			next_denom = 10;
			break;
		case 10:
			next_denom = 5;
			break;
		case 5:
			next_denom = 1;
			break;
		case 1:
			return 1;
		}

		int ways = 0;
		for (int i = 0; (i * denom) <= N; i++) {
			if( (i * denom) == N ){
				ways ++;
				break;
			}
			ways += makeChange(N - (i * denom), next_denom);
		}
		return ways;
	}
}
