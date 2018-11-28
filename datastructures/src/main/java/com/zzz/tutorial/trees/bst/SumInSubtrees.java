package com.zzz.tutorial.trees.bst;

import java.util.LinkedList;
import java.util.Queue;

import javax.swing.text.html.HTMLEditorKit.InsertHTMLTextAction;

/**
 * Given a binary tree containing n nodes. The problem is to count subtress
 * having total node�s data sum equal to a given value x.
 * <p>
 * https://www.geeksforgeeks.org/count-subtress-sum-given-value-x/
 */
public class SumInSubtrees {

    private Node root = new Node(null, 0, null);

    private static class Node {
        private Node left;
        private int data;
        private Node right;
        private int sum;

        Node(Node left, int data, Node right) {
            this.left = left;
            this.data = data;
            this.right = right;
            this.sum = 0;
        }

        public String toString() {
            return String.valueOf(data);
        }
    }

    /**
     * BFS for a tree
     * <p>
     * This will be used to generate a sum from each node Quadratic performing
     * algorithm.
     */
    public int bfs(Node root, int target) {
        if (root == null)
            return 0;
        Queue<Node> q = new LinkedList<Node>();
        q.offer(root);
        int sum = 0;
        int count = 0;
        while (!q.isEmpty()) {
            sum = 0;
            Node temp = q.poll();
            if (temp.left != null)
                q.offer(temp.left);
            if (temp.right != null)
                q.offer(temp.right);
            System.out.print(temp.data + " ");
            sum = preOrder(temp);
            if (sum == target) {
                count++;
            }
        }
        return count;
    }

    /**
     * Pre-Order traversal for a Binary tree
     */
    public int preOrder(Node root) {
        if (root == null)
            return 0;
        int sum = 0;
        if (root.left != null)
            sum += preOrder(root.left);
        sum += root.data;
        if (root.right != null)
            sum += preOrder(root.right);
        return sum;
    }

    public void insertLeft(Node root, int data) {
        Node newNode = new Node(null, data, null);
        root.left = newNode;
    }

    public void insertRight(Node root, int data) {
        Node newNode = new Node(null, data, null);
        root.right = newNode;
    }

    public static void main(String[] args) {
        SumInSubtrees tree = new SumInSubtrees();
        tree.root.data = 5;
        tree.insertLeft(tree.root, -10);// tree.root.left.data = -10;
        tree.insertLeft(tree.root.left, 9);// tree.root.left.left.data = 9;
        tree.insertRight(tree.root.left, 8);// tree.root.left.right.data = 8;

        tree.insertRight(tree.root, 3);// tree.root.right.data = 3;
        tree.insertLeft(tree.root.right, -4);// tree.root.left.left.data = -4;
        tree.insertRight(tree.root.right, 7);// tree.root.left.right.data = 7;

        // System.out.println(tree.preOrder(tree.root.left));
        System.out.println("\n" + tree.bfs(tree.root, 7));
    }

}
