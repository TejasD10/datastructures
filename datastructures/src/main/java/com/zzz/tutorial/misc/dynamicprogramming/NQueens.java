package com.zzz.tutorial.misc.dynamicprogramming;

// @formatter:off
/**
 * Given an NxN matrix and N queens, place each queen at a safe location from each other.
 * No queen should be able to attack no other queen.
 *
 */
// @formatter:on
public class NQueens {
	public static void main(String[] args) {
		char[][] input = { { 'X', 'X', 'X', 'X' }, { 'X', 'X', 'X', 'X' }, { 'X', 'X', 'X', 'X' },
				{ 'X', 'X', 'X', 'X' } };
		placeQueens(input, 4, 0, 0);
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input.length; j++) {
				System.out.print(input[i][j] + "\t");
			}
			System.out.println();
		}
	}

	private static boolean placeQueens(char[][] input, int N, int row, int cur) {
		if (cur >= N)
			return true;

		for (int i = 0; i < input.length; i++) {
			if (isSafe(input, row, i)) {
				input[row][i] = 'Q';
				if (!placeQueens(input, N, row + 1, cur + 1)) {
					input[row][i] = 'X';
					continue;
				} else
					return true;
			}
		}
		return false;
	}

	private static boolean isSafe(char[][] input, int row, int col) {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < input.length; j++) {
				if (input[i][j] == 'Q') {
					if (i == row || j == col) // same row or same column
						return false;
					if ((row + col) == (i + j)) // bottom-right to top right
												// diagonal
						return false;
					if ((row - col) == (i - j)) // top - left to bottom - right
												// diagonal
						return false;
				}
			}
		}
		return true;
	}
}
