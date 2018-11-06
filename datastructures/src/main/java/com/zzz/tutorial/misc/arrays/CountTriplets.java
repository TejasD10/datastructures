package com.zzz.tutorial.misc.arrays;

import java.util.Arrays;

public class CountTriplets {

    public static void main(String args[]) {
//        int[] input = {5, 1, 3, 4, 7};
        int[] input = {1, 3, 4, 5, 7};
//        System.out.println(countTriplets_cubic(input, 12));
        System.out.println(countTriplets(input, 12));
    }

    //O(n^3)
    private static int countTriplets_cubic(int[] input, int sum) {
        int count = 0;
        for (int i = 0; i < input.length - 2; i++) {
            for (int j = i + 1; j < input.length - 1; j++) {
                for (int k = j + 1; k < input.length; k++) {
//                    if (input[i] + input[j] + input[k] < sum) {
                    System.out.println(input[i] + ", " + input[j] + ", " + input[k]);
//                        count++;
//                    }
                }
            }
        }
        return count;
    }

    //O(n^2)
    private static int countTriplets(int[] input, int sum) {
        if (input == null || input.length < 3)
            return 0;
        int count = 0;
        int N = input.length;
        //Sort the Array - O(n Log n)
        Arrays.sort(input);
        for (int i = 0; i < N - 2; i++) {

            //input[i] will be the first character
            // For the second and third character, we will create two variables j and k
            // J starting from i + 1 and K from the back
            int j = i + 1, k = N - 1;

            // The idea is to shrink the window bringing j and k closer
            // j increments if the sum is less than the required sum
            // K decrements if the sum is higher.
            while (j < k) {

                if (input[i] + input[j] + input[k] >= sum) {
                    k--;
                } else {
                    // For e.g. 1,3,4,5,7
                    // If 1 + 3 + 7 is smaller than the sum, the sum with the elements in between
                    // will also be smaller so we can add them in the answer.
                    count += (k - j);
                    j++;
                }
            }
        }
        return count;
    }
}
