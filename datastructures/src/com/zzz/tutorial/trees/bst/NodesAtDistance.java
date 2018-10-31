package com.zzz.tutorial.trees.bst;

import java.util.ArrayList;
import java.util.List;

public class NodesAtDistance {

    private static class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "" + data;

        }
    }

    public void insert(int value) {
        root = insert(root, value);
    }

    public Node insert(Node root, int value) {
        if (root == null) {
            return new Node(value, null, null);
        }
        if (value < root.data) {
            root.left = insert(root.left, value);
        } else {
            root.right = insert(root.right, value);
        }
        return root;
    }

    public void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.data + " ");
        if (root.left != null)
            preorder(root.left);
        if (root.right != null)
            preorder(root.right);
    }

    private Node root;

    public List<Integer> nodesAtDistance(int search, int k) {
        if (root == null) {
            return null;
        }
        Node target = search(root, search);

        if (target == null) {
            return null;
        }
        List<Integer> result = new ArrayList<>();

        // Get the nodes from below
        List<Integer> fromLeft = nodesAtDistanceChildren(target, k);

        //Find the distance from root to target
        // Decrement it by 1 as it is counting the root as wel

        int dist = distFromRoot(root, target) - 1;
        List<Integer> fromRoot = null;
        if (dist == k) // Add the root node if it is directly at k distance from target
            result.add(root.data);
        else {
            fromRoot = nodesAtDistanceFromRoot(root.right, k - dist - 1); // k - dist for the remaining distance and -1 as we are moving right
        }

        if (fromLeft != null && !fromLeft.isEmpty()) result.addAll(fromLeft);
        if (fromRoot != null && !fromRoot.isEmpty()) result.addAll(fromRoot);
        return result;
    }

    private int distFromRoot(Node root, Node target) {
        if (root == null || target == null)
            return 0;
        if (root.data == target.data)
            return 1;
        // use BST property
        if (root.data < target.data)
            return 1 + distFromRoot(root.right, target);
        else return 1 + distFromRoot(root.left, target);
    }

    private List<Integer> nodesAtDistanceFromRoot(Node target, int k) {
        List<Integer> res = new ArrayList<>();
        if (target == null)
            return res;
        if (k == 0) {
            res.add(target.data);
            return res;
        }
        List<Integer> left = nodesAtDistanceChildren(target.left, k - 1);
        List<Integer> right = nodesAtDistanceChildren(target.right, k - 1);
        if (left != null && !left.isEmpty()) res.addAll(left);
        if (right != null && !right.isEmpty()) res.addAll(right);

        return res;

    }

    private List<Integer> nodesAtDistanceChildren(Node target, int k) {
        List<Integer> res = new ArrayList<>();
        if (target == null)
            return res; // Return an empty list
        if (k == 0) {
            res.add(target.data);
            return res;
        }
        List<Integer> left = nodesAtDistanceChildren(target.left, k - 1);
        List<Integer> right = nodesAtDistanceChildren(target.right, k - 1);
        if (left != null && !left.isEmpty()) res.addAll(left);
        if (right != null && !right.isEmpty()) res.addAll(right);

        return res;
    }

    private Node search(Node root, int search) {
        if (root == null) {
            return null;
        }
        if (root.data == search) {
            return root;
        }
        if (search < root.data)
            return search(root.left, search);
        else {
            return search(root.right, search);
        }

    }

    public static void main(String args[]) {
        NodesAtDistance nd = new NodesAtDistance();
        nd.insert(20);
        nd.insert(8);
        nd.insert(22);
        nd.insert(4);
        nd.insert(12);
        nd.insert(10);
        nd.insert(14);
        System.out.println(nd.nodesAtDistance(8, 2));

    }

}
