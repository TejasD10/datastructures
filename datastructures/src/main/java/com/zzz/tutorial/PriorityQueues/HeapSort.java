package com.zzz.tutorial.PriorityQueues;

public class HeapSort<Key extends Comparable> {

	private static final int TOP = 0;

	public static void sort(Comparable input[]) {
		if (input == null) {
			return;
		}
		int N = input.length - 1;

		// Create the heap using the bottom-up approach
		for (int i = N / 2 - 1; i >= 0; i--) {
			sink(input, i, N);
		}
		for (Comparable i : input) {
			System.out.print(i + " ");
		}

		// Keep Removing the max until there are no more elements in the heap
		for (int i = 0; i <= input.length - 1; i++) {
			swap(input, TOP, N--);
			sink(input, TOP, N);
		}

		// Print Sorted Array
		System.out.println("\nSorted Array");
		for (Comparable i : input) {
			System.out.print(i + " ");
		}

	}

	private static void sink(Comparable input[], int i, int N) {
		// return if there is nothing to do
		if (input == null || N == 0)
			return;
		int j;
		while ((i * 2 + 1) <= N) {
			j = i * 2 + 1;
			if (j < N && compare(input[j], input[j + 1]) < 0)
				j++;
			if (compare(input[i], input[j]) > 0)
				break;
			swap(input, j, i);
			i = j;
		}
	}

	private static int compare(Comparable i, Comparable j) {
		return i.compareTo(j);
	}

	private static void swap(Comparable input[], int i, int j) {
		Comparable temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}
}
