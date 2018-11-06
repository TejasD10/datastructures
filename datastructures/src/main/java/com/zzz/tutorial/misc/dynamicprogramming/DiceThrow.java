package com.zzz.tutorial.misc.dynamicprogramming;

public class DiceThrow {

    public static void main(String args[]) {
        int faces = 4, dice = 3, sum = 5;

        System.out.println(diceThrowRecursive(faces, dice, sum));

    }

    private static int diceThrowRecursive(int faces, int dice, int sum) {
        if (dice == 1) {
            return 1; // There is only one way you can get to that sum
        }
        if (sum == 0)
            return 1;
        int ways = 0;
        for (int i = 1; i < sum; i++)
            ways += diceThrowRecursive(faces, dice - 1, sum - i);
        return ways;
    }
}
