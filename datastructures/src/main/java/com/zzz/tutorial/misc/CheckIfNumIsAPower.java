package com.zzz.tutorial.misc;

/**
 * Check if a number can be expressed as a power i.e. in the form of x^y
 */
public class CheckIfNumIsAPower {

    public static void main(String args[]) {
        for (int i = 1; i < 100; i++) {
            if (checkIsPower(i)) {
                System.out.print(i + " ");
            }
        }
    }

    private static boolean checkIsPower(int num) {
        if (num < 1) {
            return false;
        }
        if (num <= 2) return true; // 1 = 1^1 and 2 = 2^1
        for (int x = 2; x < Math.sqrt(num); x++) {
            int y = 2;

            double p = Math.pow(x, y);

            while (p <= num) {
                if (p == num) return true;
                y++;
                p = Math.pow(x, y);
            }
        }
        return false;
    }
}
