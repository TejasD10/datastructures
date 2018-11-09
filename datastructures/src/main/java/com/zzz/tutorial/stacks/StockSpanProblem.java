package com.zzz.tutorial.stacks;

import java.util.Stack;

public class StockSpanProblem {

    public static void main(String args[]) {
        int input[] = {10, 4, 5, 90, 120, 80};

        int[] result = calculateStockSpan(input);
        for (int item : result)
            System.out.print(item + " ");
    }

    private static int[] calculateStockSpan(int[] input) {
        // Create the blank array to hold the result
        int[] result = new int[input.length];

        // Boundary checks
        if (input.length == 0)
            return result; // Return an empty int[] instead of a null

        // Create the stack to keep the indexes of the elements greater than
        // the ith element that we are looping over.
        Stack<Integer> stack = new Stack<>();

        // We know that, the span of the first element is always 1
        result[0] = 1;
        stack.push(0); // Index of the first element

        // Loop over the elements
        for (int i = 1; i < input.length; i++) {

            // Remove all the elements from the stack
            // which are smaller than the current element
            while (!stack.empty() && input[stack.peek()] <= input[i])
                stack.pop();

            // Calculate the span for the current element
            result[i] = stack.empty() ? (i + 1) : (i - stack.peek());

            // Push the i on the stack
            stack.push(i);
        }
        return result;
    }
}
