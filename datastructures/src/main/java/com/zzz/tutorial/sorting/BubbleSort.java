package com.zzz.tutorial.sorting;

/**
 * 
 * Implementing a bubble sort algorithm and counting the number of swaps made to
 * sort.
 *
 */
public class BubbleSort {
	/**
	 * 
	 * 
	 * 3,2,1 -> 2,3,1 -> 2,1,3 -> 1,2,3
	 */
	public static void sort(int[] input) {
		if (input == null || input.length == 0)
			return;
		int swaps = 0;
		for (int i = input.length - 1; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				if (input[j] > input[j + 1]) {
					swap(input, j, j + 1);
					swaps++;
				}
			}
		}
		System.out.println("Arrays is sorted in " + swaps + " swaps.");
		System.out.println("First Element: " + input[0]);
		System.out.println("Last Element: " + input[input.length - 1]);
	}

	private static void swap(int[] input, int i, int j) {
		int temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}

	public static void main(String[] args) {
		//sort(new int[] { 3, 2, 1 });
		sort(new int[] {-2,-1,0});
	}
}
