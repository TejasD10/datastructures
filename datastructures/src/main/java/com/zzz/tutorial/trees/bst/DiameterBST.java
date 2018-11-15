package com.zzz.tutorial.trees.bst;

public class DiameterBST {

    private static class Node {
        private int data;
        private Node left, right;

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public String toString() {
            return String.valueOf(this.data);
        }
    }

    public static void main(String args[]) {
        Node root = new Node(1, new Node(2, new Node(3, null, null), new Node(4, null, null)), new Node(5, null, null));
        System.out.println(diameter(root));

    }

    public static int diameter(Node root) {
        /*
            Diameter of a tree is the max of the below
            1. Max height of the left subtree
            2. Max height of the right subtree
            3. Max of Left and Right Diameters
         */
        if (root == null)
            return 0;

        // Get the left height
        int lheight = height(root.left);
        int rheight = height(root.right);

        // Get the diameter of the left and right subtrees
        int ldiameter = diameter(root.left);
        int rdiameter = diameter(root.right);

        return Math.max(lheight + rheight + 1, Math.max(ldiameter, rdiameter));

    }

    private static int height(Node right) {
        if (right == null)
            return 0;
        return 1 + Math.max(height(right.left), height(right.right));
    }
}
