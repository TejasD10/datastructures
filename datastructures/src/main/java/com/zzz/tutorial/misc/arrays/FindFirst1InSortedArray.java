package com.zzz.tutorial.misc.arrays;

public class FindFirst1InSortedArray {

    public static void main(String args[]) {
        int[] inputzeros = {0, 0, 0, 0};
        int[] inputones = {1, 1, 1, 1};
        int[] input = {0, 0, 0, 0, 1, 1, 1, 1};


        System.out.println(findFirstIndex(inputzeros));
        System.out.println(findFirstIndex(inputones));
        System.out.println(findFirstIndex(input));
    }

    private static int findFirstIndex(int[] input) {
            if (input[0] == 1) // The first number is 1, edge case
                return 0;
            if (input[input.length - 1] == 0) // Edge case, where there are no 1's
            return -1;
        return binarySearch(input, 0, input.length - 1);
    }

    private static int binarySearch(int[] input, int lo, int hi) {
        if (lo > hi)
            return -1;
        int mid = (lo + hi) / 2;
        if (input[mid] == 1 && input[mid - 1] == 0)
            return mid;
        if (input[mid] == 1)
            return binarySearch(input, lo, mid - 1);
        else return binarySearch(input, mid + 1, hi);
    }
}
