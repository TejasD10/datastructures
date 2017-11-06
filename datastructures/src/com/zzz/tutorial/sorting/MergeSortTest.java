package com.zzz.tutorial.sorting;

import com.zzz.tutorial.PriorityQueues.HeapSort;
import com.zzz.tutorial.util.RandomArray;

public class MergeSortTest {
	public static void main(String[] args) {
		RandomArray<Integer> rand = new RandomArray<>();
		Integer input [] = rand.generateRandomArray(1000);
		rand.print(input);
		new MergeSort(input).sort();
		System.out.println();
		rand.print(input);
	}
}
