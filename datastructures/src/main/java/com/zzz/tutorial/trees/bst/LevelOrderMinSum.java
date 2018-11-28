package com.zzz.tutorial.trees.bst;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderMinSum {

    //root of the tree;
    private Node root;

    public static void main(String args[]) {
        LevelOrderMinSum tree = new LevelOrderMinSum();
        tree.root = new Node(4, null, null);
        tree.insertLeft(tree.root, 6);
        tree.insertRight(tree.root, 2);
        tree.insertLeft(tree.root.left, 30);
        tree.insertRight(tree.root.left, 80);
        tree.insertLeft(tree.root.right, 7);
        tree.levelOrder();
        System.out.println("\nMin Sum:" + tree.findLevelWithMinSum());
    }

    public int findLevelWithMinSum() {
        if (root == null)
            return -1;
        //The sum for the first level i.e. root
        int sum = 0;
        int min = root.data;
        ArrayList<Node> list = new ArrayList<>();
        list.add(root);

        while (!list.isEmpty()) {
            sum = 0;
            ArrayList<Node> subList = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                Node temp = list.get(i);
                sum += temp.data;
                if (temp.left != null)
                    subList.add(temp.left);
                if (temp.right != null)
                    subList.add(temp.right);
            }
            list = subList;
            if (min > sum)
                min = sum;
        }
        return min;
    }

    public Node getRoot() {
        return root;
    }

    public void insertLeft(Node root, int data) {
        if (root == null)
            return;
        Node newNode = new Node(data, null, null);
        root.left = newNode;
    }

    public void insertRight(Node root, int data) {
        if (root == null)
            return;
        Node newNode = new Node(data, null, null);
        root.right = newNode;
    }

    public void levelOrder() {
        if (root == null) {
            System.out.println("Empty Tree");
            return;
        }
        Queue<Node> q = new LinkedList<Node>();
        q.offer(root);
        while (!q.isEmpty()) {
            Node temp = q.poll();
            System.out.print(temp.data + " ");
            if (temp.left != null)
                q.offer(temp.left);
            if (temp.right != null)
                q.offer(temp.right);
        }

    }

    private static class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public String toString() {
            return String.valueOf(data);
        }

    }
}
