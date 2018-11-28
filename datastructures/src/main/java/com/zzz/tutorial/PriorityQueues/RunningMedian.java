package com.zzz.tutorial.PriorityQueues;

import java.util.Arrays;
import java.util.Scanner;

/**
 * The median of a dataset of integers is the midpoint value of the dataset for
 * which an equal number of integers are less than and greater than the value.
 * To find the median, you must first sort your dataset of integers in
 * non-decreasing order, then:
 * 
 * If your dataset contains an odd number of elements, the median is the middle
 * element of the sorted sample. In the sorted dataset , is the median. If your
 * dataset contains an even number of elements, the median is the average of the
 * two middle elements of the sorted sample. In the sorted dataset , is the
 * median.
 * 
 * 
 */
public class RunningMedian {

	/**
	 * minHeap stores the minimum of the greater elements than the median.
	 * maxHeap stores the maximum of the smaller elements than the median
	 */
	private static Heap<Integer> minHeap = new Heap<>(Heap.HeapType.MIN);
	private static Heap<Integer> maxHeap = new Heap<>(Heap.HeapType.MAX);

	private static double MEDIAN = 0.0;

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] a = new int[n];
		for (int a_i = 0; a_i < n; a_i++) {
			a[a_i] = in.nextInt();
		}
		printMedian(a);

		/*for (int i = 1; i < 6; i++) {
			minHeap.insert(i);
		}
		System.out.println(minHeap);*/
	}

	public static void printMedian(int a[]) {
		for (int i : a) {
			getMedian(i);
			System.out.printf("%.1f\n", MEDIAN);
		}
	}

	private static void getMedian(int i) {

		/**
		 * If the sizes of the both the heaps are same, insert the element by
		 * comparing it to the median in the max or min heap respectively.
		 */
		if (minHeap.size == maxHeap.size) {
			if (i < MEDIAN) {
				// insert i in the maxHeap
				maxHeap.insert(i);
				MEDIAN = (int) maxHeap.peek();
			} else {
				minHeap.insert(i);
				MEDIAN = (int) minHeap.peek();
			}
		} else if (minHeap.size() - maxHeap.size() == 1) { // Right Heap has one
															// more element
			// insert element into the left heap if the element is less than the
			// median
			// so the heap would be balanced and the average becomes the median
			if (i < MEDIAN) {
				maxHeap.insert(i);
			} else {
				// Now the element has to be entered in the minHeap, but in
				// order to balance the heap
				// we should move the top element from the minHeap to maxHeap.
				maxHeap.insert((Integer) minHeap.poll()); // upcast to make it
															// comparable

				// Now insert in minHeap
				minHeap.insert(i);
			}
			MEDIAN = ((int) minHeap.peek() + (int) maxHeap.peek()) / 2.0;
		} else if (maxHeap.size() - minHeap.size() == 1) { // Left Heap has one
															// more element
			// insert element into the left heap if the element is less than the
			// median
			// so the heap would be balanced and the average becomes the median
			if (i > MEDIAN) {
				minHeap.insert(i);
			} else {
				// Now the element has to be entered in the maxHeap, but in
				// order to balance the heap
				// we should move the top element from the maxHeap to minHeap.
				minHeap.insert((Integer) maxHeap.poll()); // upcast to make it
															// comparable

				// Now insert in maxHeap
				maxHeap.insert(i);
			}
			MEDIAN = ((int) minHeap.peek() + (int) maxHeap.peek()) / 2.0;
		}
	}

	private static class Heap<K extends Comparable<K>> {
		private int size;
		private Comparable[] elements;

		private static final int TOP = 0;

		private static final int EMPTY = -1;

		private HeapType heapType;

		private enum HeapType {
			MIN, MAX
		}

		public int size() {
			return size + 1;
		}

		private void ensureCapacity() {
			if (size() > (elements.length / 2)) { // increase capacity if the array is half full.
				elements = Arrays.copyOf(elements, elements.length * 2); // double the capacity
			}
		}

		public Heap(HeapType heapType) {
			elements = new Comparable[10];
			this.heapType = heapType;
			size = EMPTY;
		}

		private int getLeftChild(int index) {
			if (size == EMPTY)
				throw new IllegalStateException();
			return (index * 2) + 1;
		}

		private int getRightChild(int index) {
			if (size == EMPTY)
				throw new IllegalStateException();
			return (index * 2) + 2;
		}

		private int getParent(int index) {
			if (size == EMPTY)
				throw new IllegalStateException();
			return (index - 1) / 2;
		}

		public void insert(K item) {
			ensureCapacity(); // Check capacity before inserting
			elements[++size] = item;
			heapifyUp();
		}

		public Comparable peek() {
			if (size == EMPTY)
				return null;
			return elements[TOP];
		}

		public Comparable poll() {
			if (size == EMPTY)
				return null;
			Comparable item = elements[TOP];

			elements[TOP] = elements[size];
			elements[size--] = null;
			heapifyDown();
			return item;
		}

		private boolean hasLeftChild(int index) {
			return ((index * 2) + 1 <= size);
		}

		private boolean hasRightChild(int index) {
			return ((index * 2) + 2 <= size);
		}

		/**
		 * Heapify UP - Reposition the element inserted at the bottom at the
		 * right position.
		 */
		private void heapifyUp() {
			int index = size;
			if (heapType == HeapType.MIN) {
				while (index > TOP && (elements[index].compareTo(elements[getParent(index)])) < 0) {
					swap(index, getParent(index));
					index = getParent(index);
				}
			} else {
				while (index > TOP && (elements[index].compareTo(elements[getParent(index)])) > 0) {
					swap(index, getParent(index));
					index = getParent(index);
				}
			}
		}

		private void heapifyDown() {
			int index = TOP;
			if (heapType == HeapType.MIN) {
				while (hasLeftChild(index)) {
					int minChildIndex = getLeftChild(index);
					if (hasRightChild(index)
							&& elements[getRightChild(index)].compareTo(elements[minChildIndex]) < 0) {
						minChildIndex = getRightChild(index);
					}
					if (elements[index].compareTo(elements[minChildIndex]) < 0)
						break;
					else {
						swap(index, minChildIndex);
					}
					index = minChildIndex;
				}
			} else {
				while (hasLeftChild(index)) {
					int minChildIndex = getLeftChild(index);
					if (hasRightChild(index)
							&& elements[getRightChild(index)].compareTo(elements[minChildIndex]) > 0) {
						minChildIndex = getRightChild(index);
					}
					if (elements[index].compareTo(elements[minChildIndex]) > 0)
						break;
					else {
						swap(index, minChildIndex);
					}
					index = minChildIndex;
				}
			}
		}

		private void swap(int i, int j) {
			Comparable temp = elements[i];
			elements[i] = elements[j];
			elements[j] = temp;
		}

		public String toString() {
			StringBuffer sb = new StringBuffer();
			for (Comparable comparable : elements) {
				if (comparable != null) {
					sb.append(comparable);
					sb.append(" ");
				}
			}
			return sb.toString();
		}

	}
}
