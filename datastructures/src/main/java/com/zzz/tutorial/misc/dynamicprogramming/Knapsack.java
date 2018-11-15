package com.zzz.tutorial.misc.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class Knapsack {
    public static void main(String args[]) {
        int[] vals = {6, 10, 12};
        int[] weights = {1, 2, 3};
        int maxWeight = 5;
        System.out.println(knapsack(vals, weights, 5));
    }

    public static int knapsack(int[] vals, int[] weights, int maxWeight) {
        // Check for the boundary case
        // if either of one is empty there is nothing to be put in the knapsack
        if (vals.length == 0 || weights.length == 0)
            return 0;
        // Since we are representing this as an array,
        // the length of both the vals and weights should be equal
        if (vals.length != weights.length)
            return -1;

        Map<Integer, Integer> cache = new HashMap<>();
        return knapsack(vals, weights, maxWeight, 0);
    }

    /**
     * This is the private recursive method that will determine the maximum weight
     * that the bag/knapsack will hold
     */
    private static int knapsack(int[] vals, int[] weights, int maxWeight, int index) {
        // Base Case - 1
        if (index == weights.length)
            return 0; // There is no weight that the knapsack can hold

        // Base Case - 2 If out of my available weights there is nothing we can add
        // to the knapsack at this index/iteration
        if (weights[index] > maxWeight)
            return knapsack(vals, weights, maxWeight, index + 1); // Goto the next index

        // Now we have two options
        // Find the max weight with this weight included, and without this weight included
        int max = Math.max(knapsack(vals, weights, maxWeight - weights[index], index + 1) + vals[index], knapsack(vals, weights, maxWeight, index + 1));
        return max;
    }
}
