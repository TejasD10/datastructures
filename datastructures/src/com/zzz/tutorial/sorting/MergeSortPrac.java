package com.zzz.tutorial.sorting;

public class MergeSortPrac {
    public static void mergeSort(int[] input) {
        mergeSort(input, new int[input.length], 0, input.length - 1);
    }

    /**
     * 4, 3, 2 , 8, 7
     */
    private static void mergeSort(int[] input, int[] aux, int lo, int hi) {
        if (lo >= hi)
            return;
        int mid = (lo + hi) / 2;

        mergeSort(input, aux, lo, mid);
        mergeSort(input, aux, mid + 1, hi);
        merge(input, aux, lo, hi);

    }

    private static void merge(int[] input, int[] aux, int lo, int hi) {
        // Create an aux array
        System.arraycopy(input, 0, aux, 0, input.length);

        int mid = (lo + hi) / 2;

        int rightStart = mid + 1;
        int leftStart = lo;
        for (int left = lo; left <= hi; ) {
            // Check if the lefStart crossed the mid
            if (leftStart > mid) input[left++] = aux[rightStart++];
            else if (rightStart > hi) input[left++] = aux[leftStart++];
            else if (aux[leftStart] < aux[rightStart]) input[left++] = aux[leftStart++];
            else input[left++] = aux[rightStart++];
        }
    }

    public static void main(String args[]) {
        int[] input = {4, 3, 2, 1, 6};
        mergeSort(input);
        for (int item : input) System.out.print(item + " ");
    }
}
