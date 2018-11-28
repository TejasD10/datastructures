package com.zzz.tutorial.PriorityQueues;

public class PriorityQueue<Key extends Comparable<Key>> {

	private Key elements[];
	private int N;

	private static final int TOP =1;

	@SuppressWarnings("unchecked")
	public PriorityQueue(int size) {
		elements = (Key[]) new Comparable[size + 1];
	}

	@SuppressWarnings("unchecked")
	public PriorityQueue() {
		// 10 elements can be stored
		elements = (Key[]) new Comparable[11];
	}

	// insert
	public void insert(Key i) {
		elements[++N] = i;
		swim(N);
	}

	// isEmpty
	public boolean isEmpty() {
		return (N == 0);
	}

	// sink
	public void sink(int k) {
		// Point to the first child
		int j;
		while ((k * 2) < N) {
			j = 2 * k;
			if (compare(j, j+1) < 0)
				j++;
			swap(j, k);
			k = j;
		}
	}

	// swim
	public void swim(int k) {
		while (k > TOP) {
			if (compare(k / 2, k) < 0) {
				swap(k / 2, k);
			}
			k = k >>> 1;
		}
	}

	private int compare(int i, int j) {
		return (elements[i].compareTo(elements[j]));
	}

	private void swap(int i, int j) {
		Key temp = elements[i];
		elements[i] = elements[j];
		elements[j] = temp;
	}

	// delMax
	public Key delMax() {
		Key max = elements[TOP];
		elements[TOP] = elements[N];
		elements[N--] = null;
		sink(TOP);
		return max;
	}

	// max
	public Key max() {
		if (!isEmpty())
			return elements[TOP];
		return null;
	}

	// toString
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Key key : elements) {
			if (key != null)
				sb.append(key + " ");
		}
		return sb.toString();
	}
}
