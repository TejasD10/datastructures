package com.zzz.tutorial.misc.strings;

import java.util.Scanner;

public class LongestCommonSubsequence {
	public static void main(String[] args) {

		// input//
		/*
		 * 5 6 1 2 3 4 1 3 4 1 2 1 3
		 */ Scanner in = new Scanner(System.in);
		int aLen = in.nextInt();
		int bLen = in.nextInt();

		int A[] = new int[aLen];
		int B[] = new int[bLen];

		for (int i = 0; i < aLen; i++) {
			A[i] = in.nextInt();
		}

		for (int i = 0; i < bLen; i++) {
			B[i] = in.nextInt();
		}

		int lcs[][] = new int[aLen + 1][bLen + 1], k = 0;
		int ans[] = new int[aLen >= bLen ? aLen : bLen];
		for (int i = 0; i <= aLen; i++) {
			for (int j = 0; j <= bLen; j++) {
				if (i == 0 || j == 0)
					lcs[i][j] = 0;
				else if (A[i - 1] == B[j - 1]) {
					// If both match, take the diagonal element and add one.
					lcs[i][j] = 1 + lcs[i - 1][j - 1];
					ans[k++] = A[i - 1];
				} else {
					// max of one on the left and one on the top
					lcs[i][j] = lcs[i - 1][j] >= lcs[i][j - 1] ? lcs[i - 1][j] : lcs[i][j - 1];
				}
			}
		}
		for (int i = 0; i < ans.length; i++) {
			System.out.print(ans[i] + " ");
		}

		System.out.println(lcs[aLen][bLen]);
	}
}
