package com.zzz.tutorial.misc.arrays;

public class QuickSelectKthElement {

    public static int partition(int[] input, int lo, int hi) {

        // Select the pivot
        int pivot = hi;
        int start = lo, end = hi - 1;

        // Find the right index for the pivot element
        while (start <= end) {

            // Move the start pointer forward
            // until you find elemenents smaller than the pivot
            while (input[start++] <= input[pivot]) if (start == hi) break;
            while (input[end--] >= input[pivot]) if (end == lo) break;
            if (start > end) break;
            swap(input, start, end);
        }
        swap(input, pivot, start);
        return start;
    }

    private static void swap(int[] input, int pivot, int end) {
        int temp = input[pivot];
        input[pivot] = input[end];
        input[end] = temp;
    }

    public static int kthSmallest(int[] input, int lo, int hi, int k) {
        // First check the input
        if (input == null || input.length == 0)
            return Integer.MAX_VALUE; // Error case

        // Boundary checks for K
        if (k < 0 || k > hi)
            return Integer.MAX_VALUE; // Error case

        int pos = partition(input, lo, hi);
        // Position == K
        if (pos - 1 == k - 1)
            return input[pos - 1]; // Return the Kth result
        // If the position returned is greater than K
        // branch left
        if (pos - 1 > k - 1)
            return kthSmallest(input, lo, pos - 1, k);
        // Else branch right
        return kthSmallest(input, pos + 1, k, k);
    }

    // Driver program to test above methods
    public static void main(String[] args) {
        int arr[] = new int[]{12, 3, 5, 7, 4, 19, 26};
        int k = 3;
        System.out.print("K'th smallest element is " +
                kthSmallest(arr, 0, arr.length - 1, k));
    }

}
