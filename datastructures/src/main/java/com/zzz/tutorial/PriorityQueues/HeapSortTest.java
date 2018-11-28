package com.zzz.tutorial.PriorityQueues;

import com.zzz.tutorial.util.RandomArray;

public class HeapSortTest {
	public static void main(String[] args) {
		Integer input [] = RandomArray.generateRandomArray(5);
		/*PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for(Integer n: input){
			System.out.print(n + " ");
			pq.insert(n);
		}
		System.out.println("\nPriority Queue:");
		System.out.println(pq.toString());*/
		
		HeapSort.sort(input);
	}
}
