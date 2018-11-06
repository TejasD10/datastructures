package com.zzz.tutorial.stacks;

import java.util.Stack;


public class MinOnLeft {
    public static void main(String args[]) {
//        int[] input = new int[]{
//                1, 6, 4, 10, 2, 5
//        };
        int[] input = new int[]{
                1, 3, 0, 2, 5
        };
        printMinonNearLeft(input);
    }

    private static void printMinonNearLeft(int[] input) {
        if (input == null || input.length == 0)
            return;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < input.length; i++) {
            while (!stack.empty() && stack.peek() >= input[i]) {
                stack.pop();
            }
            if (stack.empty())
                System.out.print("_");
            else
                System.out.print("," + stack.peek());

            stack.push(input[i]);
        }

    }
}
