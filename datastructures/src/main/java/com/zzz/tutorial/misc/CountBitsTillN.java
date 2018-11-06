package com.zzz.tutorial.misc;

public class CountBitsTillN {

    public static void main(String args[]) {
        int N = 3, sum = 0;
        for (int i = 1; i <= N; i++)
            sum += countsBits(i);
    }

    private static int countsBits(int i) {
        int bits = 0;
        while (i > 0) {
            if ((i & 1) == 1)
                bits++;
            i >>= 1;
        }
        return bits;
    }
}
