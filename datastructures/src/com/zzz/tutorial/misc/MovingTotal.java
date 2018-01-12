package com.zzz.tutorial.misc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class MovingTotal {
    HashSet<Integer> sums = new HashSet<>();
    private List<Integer> runningList = new ArrayList<Integer>();

    public static void main(String[] args) {
        MovingTotal movingTotal = new MovingTotal();

        movingTotal.append(new int[]{1, 2, 3});

        System.out.println(movingTotal.contains(6));
        System.out.println(movingTotal.contains(9));

        movingTotal.append(new int[]{4, 5, 6});

        System.out.println("9 : " + movingTotal.contains(9));
        System.out.println("12 : " + movingTotal.contains(12));
        System.out.println("15 : " + movingTotal.contains(15));
    }

    /**
     * Adds/appends list of integers at the end of internal list.
     */
    public void append(int[] list) {
        if (list.length == 0)
            return;
        for (int i = 0; i < list.length; i++) {
            runningList.add(list[i]);
        }
        int run = 0, sum = 0;
        int index = runningList.size() - 1;
        for (int i = 0; i < list.length; i++) {
            sum = 0;
            if (index < 2)
                break;
            while (run < 3) {
                sum += runningList.get(index - run);
                run++;
            }
            sums.add(sum);
            index--;
            run = 0;
        }

    }

    /**
     * Returns boolean representing if any three consecutive integers in the
     * internal list have given total.
     */
    public boolean contains(int total) {
        return sums.contains(total);
    }
}
