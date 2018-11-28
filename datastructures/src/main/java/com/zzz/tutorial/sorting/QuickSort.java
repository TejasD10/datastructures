package com.zzz.tutorial.sorting;

public class QuickSort {

    private static int numSwaps;

    /**
     * Input - An Integer array for sorting
     */
    public static void quickSort(int[] input) {
        if (input == null || input.length <= 0)
            return;
        /**
         * Improvements:
         * 1. Check if the array is sorted
         * 2. Random shuffle the array so it is not sorted and you don't pick the lowest pivot
         * 3. Implement some kind of a threshold to a lower limit of the size of the array and apply an iterative sort like insertion sort for same.
         */
        assert (!isSorted(input));
        quickSort(input, 0, input.length - 1);
        System.out.println("NumSwaps: " + numSwaps);
    }

    private static boolean isSorted(int[] input) {
        for (int i = 0; i < input.length - 1; i++) {
            if (input[i] > input[i + 1]) {
                return false;
            }
        }
        return true;
    }

    private static void quickSort(int[] input, int lo, int hi) {
        if (lo >= hi)
            return;
        int partition = partition(input, lo, hi);
        quickSort(input, lo, partition - 1);
        quickSort(input, partition + 1, hi);
    }

    private static int partition(int[] input, int lo, int hi) {
        int start = lo, end = hi + 1;
        while (start <= end) {
            while (input[++start] <= input[lo])
                if (start == hi) break;
            while (input[--end] >= input[lo])
                if (end == lo) break;
            if (start > end) {
                break;
            }
            swap(input, start, end);
        }
        swap(input, lo, end);
        return end;
    }

    private static void swap(int[] input, int start, int end) {
        numSwaps++;
        int temp = input[start];
        input[start] = input[end];
        input[end] = temp;
    }
}
