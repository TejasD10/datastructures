package com.zzz.tutorial.trees.bst;

public class CountBranches {

    public static int count(int[] tree) {
        int leftChild = 0, rightChild = 0, branchCount = 0;
        for (int index = 0; index < tree.length; index++) {
            leftChild = (index * 2) + 1;
            rightChild = (index * 2) + 2;
            if (leftChild < tree.length || rightChild < tree.length) {
                if (leftChild != -1 && rightChild != -1)
                    branchCount++;
            }
        }
        return branchCount;
    }

    public static void main(String[] args) {
        System.out.println(CountBranches.count(new int[]{1, 3, 1, -1, 3}));
    }

}
