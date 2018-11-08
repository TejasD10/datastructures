package com.zzz.tutorial.misc.arrays;

public class MissingNumber {

    public static void main(String args[]) {
        int[] input = {1, 2, 4, 6, 3, 7, 8};

        int result = 0;
        for (int elem : input) {
            result ^= elem;
            System.out.print(result + ", ");
        }
        System.out.println(result);

        int actual = 0;
        for (int i = 1; i <= 8; i++)
            actual ^= i;
        System.out.println(result);
        System.out.println(result ^ actual);
    }
}
