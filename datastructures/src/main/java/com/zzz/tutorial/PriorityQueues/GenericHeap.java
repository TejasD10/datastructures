package com.zzz.tutorial.PriorityQueues;

import java.util.Arrays;
import java.util.Objects;

public class GenericHeap<E extends Comparable<E>> {

    // Create the array for input storage
    private Comparable[] elements = new Comparable[16];
    // Size
    private int size = -1;

    // Points to the top of the PQ
    private static final int TOP = 0;

    public GenericHeap(E[] input) {
        // Insert the elements in the heap
        this.insertCollection(input);
    }

    private boolean hasParent(int index) {
        return this.parent(index) >= 0;
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return (2 * index) + 1;
    }

    private int rightChild(int index) {
        return (2 * index) + 2;
    }

    private boolean hasLeftChild(int index) {
        return this.leftChild(index) <= this.size;
    }

    private boolean hasRightChild(int index) {
        return this.rightChild(index) <= this.size;
    }

    private void insertCollection(E[] input) {
        if (input == null || input.length == 0)
            return;
        // Insert each element in the input array to form a heap
        Arrays.stream(input).forEach(this::insert);
    }

    public void insert(E elem) {
        // Capacity check is omitted
        this.elements[++size] = elem;
        this.heapifyUp();
    }

    public boolean isEmpty() {
        return this.size == -1;
    }

    public E peek() {
        if (this.isEmpty())
            return null;
        // Return the top element
        return (E) elements[TOP];
    }

    public E poll() {
        // Remove and return the element
        if (this.isEmpty())
            return null;
        E response = (E) elements[TOP];
        this.elements[TOP] = this.elements[size--];
        this.elements[size + 1] = null;
        heapifyDown();
        return response;
    }

    private void heapifyDown() {
        if (this.isEmpty())
            return;
        // Keep going down until the heap property is violated
        int index = TOP;
        while (hasLeftChild(index)) {
            // Assume the min index is the left most, as the leftchild is present
            int minIndex = leftChild(index);
            if (hasRightChild(index) && elements[rightChild(index)].compareTo(elements[leftChild(index)]) < 0)
                minIndex = rightChild(index);
            // Check if the heap property is still violated
            // Assuming this is a min heap
            if (this.elements[index].compareTo(this.elements[minIndex]) < 0)
                break;
            swap(index, minIndex);
            index = minIndex;
        }
    }

    private void swap(int index, int minIndex) {
        E temp = (E) this.elements[index];
        this.elements[index] = this.elements[minIndex];
        this.elements[minIndex] = temp;
    }

    private void heapifyUp() {
        if (this.isEmpty())
            return;
        int index = this.size;
        while (index > TOP && this.elements[index].compareTo(this.elements[parent(index)]) < 0) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    public GenericHeap() {

    }

    public static void main(String args[]) {
        GenericHeap<Integer> heap = new GenericHeap<>(new Integer[]{5, 6, 7, 4, 1});
        System.out.println(heap.peek());
        heap.poll();
        heap.poll();
        heap.poll();
        heap.poll();
        System.out.println("Full Heap");
        heap.print();
    }

    private void print() {
        if (this.isEmpty())
            return;
        Arrays.stream(this.elements).filter(Objects::nonNull).forEach(System.out::println);
    }
}
