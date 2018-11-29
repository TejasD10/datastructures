package com.zzz.tutorial.trees.bst;

public class MaxDiffAncestor {

    private static class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public String toString() {
            return String.valueOf(this.data);
        }
    }

    private int maxValue;
    private Node root;

    /**
     * Finds the maximum value between the node and it's ancestors
     * <i>Note</i> The minimum value for the leaf node is it's value
     */
    public int maxDiffAncestor(Node root) {
        // For root = null, return 0
        if (root == null)
            return 0;
        // If this is the leaf node, it's value is the min
        // as it does not have any children
        if (root.left == null && root.right == null)
            return root.data;

        // Find the min in the left and right subtree
        int min = Math.min(maxDiffAncestor(root.left), maxDiffAncestor(root.right));
        // Calculate the result for this tree
        this.maxValue = Math.max(maxValue, root.data - min);

        // Return the minimum of the min element found, or the root.data
        // As there could be a case where the min element may be greater than
        // the root.data
        return Math.min(root.data, min);
    }

    public static void main(String args[]) {
        MaxDiffAncestor max = new MaxDiffAncestor();
        max.root = new Node(8, new Node(3, new Node(1, null, null), new Node(6, null, null)), new Node(10, null, null));
        max.maxDiffAncestor(max.root);
        System.out.println(max.maxValue);
    }

}
