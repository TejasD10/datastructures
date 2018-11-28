package com.zzz.tutorial.stacks;


import java.util.Stack;

/**
 * Sort a stack using only one stack
 * https://www.geeksforgeeks.org/sort-stack-using-temporary-stack/
 */
public class StackSortOneStack {
    private static Stack<Integer> stackA = new Stack<Integer>();
    private static Stack<Integer> stackB = new Stack<Integer>();

    public static void main(String args[]) {
        //Fill the one stack with elements to sort
        int[] input = new int[]{1, 3, 2};
        for (Integer i : input) {
            stackA.push(i);
        }
        sort();
        printStack();
    }

    /**
     * Sort stack with one additional stack
     */
    private static void sort() {
        if (stackA.isEmpty()) {
            System.out.println("Input Empty!");
            return;
        }
        int max = 0;
        while (!stackA.isEmpty()) {
            max = stackA.pop();
            if (stackB.isEmpty() || stackB.peek() <= max)
                stackB.push(max);
            else {
                while (!stackB.isEmpty() && stackB.peek() > max) {
                    stackA.push(stackB.pop());
                }
                stackB.push(max);
            }
        }
    }
    private static void printStack(){
        while(!stackB.isEmpty()){
            System.out.print(stackB.pop() + " ");
        }
    }
}
