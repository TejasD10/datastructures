package com.zzz.tutorial.trees.bst;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrintVertical {
    private static class Node {
        private int value;
        private Node left, right;
        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    // Root of the tree
    private Node root;

    public static void main(String args[]) {
        Node root = new Node(5, new Node(4, new Node(3, null, null), new Node(6, null, null)),
                new Node(10, new Node(12, null, null), new Node(14, null, null)));
        Map<Integer, List<Integer>> maps = new HashMap<>();
        printVertical(root, maps, 0);

        // Iterate through the map and print the result
        for (Map.Entry<Integer, List<Integer>> entry : maps.entrySet()) {
            System.out.print(entry.getKey() + ":" + entry.getValue());
            System.out.println();
        }
    }

    private static void printVertical(Node root, Map<Integer, List<Integer>> maps, int index) {
        if (root == null)
            return;
        // Get the list for the index
        List<Integer> currListForIndex = maps.getOrDefault(index, new ArrayList<>());
        // Add the current item on the index
        currListForIndex.add(root.value);
        // Put the updated list in the map
        maps.put(index, currListForIndex);

        //Branch Left and Right
        // Branch left with index-1 and right index+1
        printVertical(root.left, maps, index - 1);
        printVertical(root.right, maps, index + 1);
    }

}
