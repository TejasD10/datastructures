package com.zzz.tutorial.misc.arrays;

public class EquilibriumIndex {

    public static void main(String args[]) {
        int[] input = {-7, 1, 5, 2, -4, 3, 0};
        equilIndex(input);
    }

    /**
     * Find the equilibrium index between 1 and n-1
     *
     * @param input
     * @return
     */
    private static void equilIndex(int[] input) {
        int leftSum = input[0];
        int rightSum = 0, total = 0;

        // Calculate the total sum of the array
        for (int i = 0; i < input.length; i++)
            total += input[i];

        // Start leftSum with 0, rightSum with totalSum - a[0]
        for (int i = 1; i < input.length - 1; i++) {
            rightSum = total - leftSum - input[i];
            if (leftSum == rightSum) { // Found an index
                System.out.print(i + " ");
            }
            leftSum += input[i];
        }
    }
}
