package com.zzz.tutorial.misc.arrays;

import java.util.*;

public class KStreamsProblem {
    public static void main(String args[]) {
        int[] input = {5, 2, 1, 3, 2, 4, 5, 4, 1, 4, 5};

        // This will hold the top K elements
        int K = 4;
        int[] top = new int[K + 1]; // Return top 4 elements

        // Initialize all the elements to -1
        for (int i = 0; i < top.length; i++) {
            top[i] = -1;
        }

        // Hold the frequency and provide O(1) access
        Map<Integer, Integer> freq = new HashMap<>();

        for (Integer elem : input) {
            // Check if there is a freq for this member
            if (freq.containsKey(elem)) {
                freq.put(elem, freq.get(elem) + 1);
            } else {
                freq.put(elem, 1);
            }

            // Put the element in the top list
            top[K] = elem;

            // Find the first index of the element in the top
            int index = 0;
            for (; index < top.length - 1; index++) {
                if (top[index] == elem)
                    break;
            }
            index -= 1;

            while (index >= 0) {
                if (freq.containsKey(top[index + 1]) && freq.containsKey(top[index]) && freq.get(top[index + 1]) > freq.get(top[index])) {
                    swap(top, index);
                } else if (freq.containsKey(top[index + 1]) && freq.containsKey(top[index]) && freq.get(top[index + 1]).equals(freq.get(top[index])) && top[index] > top[index + 1]) {
                    swap(top, index);
                } else if (top[index] == -1) {
                    swap(top, index);
                } else
                    break;
                index -= 1;
            }
            // Print the top K elements
            for (int i = 0; i < K; i++) {
                if (top[i] != -1)
                    System.out.print(top[i] + " ");
            }
            System.out.println();
        }
    }

    private static void swap(int[] top, int index) {
        int temp = top[index];
        top[index] = top[index + 1];
        top[index + 1] = temp;
    }
}
