package com.zzz.tutorial.PriorityQueues;

import java.util.Arrays;

public class GenericHeapSort<K extends Comparable> {

    public static void sort(Comparable[] input) {
        // Boundary Check
        if (input == null || input.length == 0)
            return;

        // Get the max length of the array to be used during the sink operation
        int N = input.length - 1;

        // Pick the first parent and start sinking it down to
        // satisfy the heap order property
        for (int i = (N - 1) / 2; i >= 0; i--) {
            sink(input, i, N);
        }

        // Pick the max element and store it at the last
        // This element is now ordered in respect to the array
        while (N >= 0) {
            swap(input, 0, N--);
            sink(input, 0, N);
        }

        Arrays.stream(input).forEach(System.out::print);
    }

    private static void sink(Comparable[] input, int i, int N) {
        if (N == 0) return; // Return when there are no elements to sink
        // Start the sink process
        int child;
        while ((i * 2) + 1 <= N) { // Here (i*2) + 1 will give the left child
            child = i * 2 + 1;
            if (child < N && input[child].compareTo(input[child + 1]) < 0)
                child++;
            if (input[i].compareTo(input[child]) > 0)
                break;
            swap(input, i, child);
            i = child;
        }
    }

    private static void swap(Comparable[] input, int i, int j) {
        Comparable temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

    public static void main(String arsgs[]) {
        sort(new Integer[]{4, 10, 3, 5, 1});
    }

}
