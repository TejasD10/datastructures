package com.zzz.tutorial.trees.bst;

import java.util.LinkedList;
import java.util.Queue;

public class MaxWidthTree {

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
        System.out.println(maxWidth(root));
    }

    private static int maxWidth(Node root) {
        if (root == null)
            return 0;
        Queue<Node> queue = new LinkedList<Node>();

        // Add root to the stack and init max with 1
        queue.offer(root);
        int maxWidth = 1;

        while (!queue.isEmpty()) {
            int prev_parents = maxWidth;
            while (prev_parents > 0) {
                // Pop the first node
                Node temp = queue.poll();

                // Add children to the queue
                if (temp.left != null)
                    queue.offer(temp.left);
                if (temp.right != null)
                    queue.offer(temp.right);
                prev_parents--;
            }
            maxWidth = Math.max(maxWidth, queue.size());
        }
        return maxWidth;
    }

}
