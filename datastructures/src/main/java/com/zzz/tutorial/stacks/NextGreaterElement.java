package com.zzz.tutorial.stacks;

import java.util.Stack;

public class NextGreaterElement {

    public static void main(String args[]) {
        int input[] = {13, 7, 6, 12};
        int sorted[] = {1, 2, 3, 4, 5};
        int reverse[] = {5, 4, 3, 2, 1};

        System.out.println("Input");
        printNextGreaterElement(input);
        System.out.println("Sorted");
        printNextGreaterElement(sorted);
        System.out.println("Reversed");
        printNextGreaterElement(reverse);
    }

    private static void printNextGreaterElement(int[] input) {
        // Check the boundaries
        if (input.length == 0)
            return;
        if (input.length == 1)
            System.out.println(input[0] + " -> -1"); // For the only element, there is not next element

        // Create a stack for storing the elements
        // for which the max is not found
        Stack<Integer> stack = new Stack<>();
        // Push the first element on the stack
        stack.push(input[0]);
//        int input[] = {13, 7, 6, 12};
        for (int i = 1; i < input.length; i++) {
            // Pop elements that are smaller than the current element
            // as the current element would be the NGE for the popped elements
            while (!stack.empty() && stack.peek() <= input[i]) {
                System.out.println(stack.peek() + " -> " + input[i]);
                stack.pop();
            }
            stack.push(input[i]);
        }
        if (!stack.empty()) {
            while (!stack.empty())
                System.out.println(stack.pop() + " -> -1");
        }
    }
}
