package com.zzz.tutorial.PriorityQueues;

public class PQTest {
	public static void main(String args[]){
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.insert(10);
		pq.insert(13);
		pq.insert(8);
		pq.insert(15);
		pq.insert(7);
		pq.insert(20);
		System.out.println(pq.toString());
		System.out.println(pq.delMax());
		System.out.println(pq.toString());
	}
}
