package com.zzz.tutorial.misc.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StoneThrow {
    public static void main(String args[]) {
//        System.out.println(lastStoneWeight(Arrays.asList(3, 2, 4, 5)));
        System.out.println(lastStoneWeight(Arrays.asList(
                46188086,
                339992587,
                742976890,
                801915058,
                393898202,
                717833291,
                843435009,
                361066046,
                884145908,
                668431192,
                586679703,
                792103686,
                85425451,
                246993674,
                134274127,
                586374055,
                923288873,
                292845117,
                399188845,
                842456591,
                410257930,
                333998862,
                16561419,
                624279391,
                459765367,
                969764608,
                508221973,
                82956997,
                437034793,
                553121267,
                554066040,
                199416087
        )));
    }

    public static int lastStoneWeight(List<Integer> a) {
        // Boundary cases
        if (a == null || a.size() == 0)
            return 0;
        if (a.size() == 1) // That is the remaining stone
            return a.get(0);

        // Need to sort the collection O(n log n)
        Collections.sort(a);
        a.stream().forEach(item -> System.out.println(item));
        int result = 0;
        for (int i = a.size() - 1; i >= 0; i--) {
            if (result == 0 && i >= 1 && a.get(i - 1) == a.get(i)) {
                i--;
            } else {
                if (result != 0)
                    result = Math.abs(a.get(i) - result);
                else if (i >= 1) {
                    result = Math.abs(a.get(i - 1) - a.get(i));
                    i--;
                }
            }
        }
        return result;
    }
}
