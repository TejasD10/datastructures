package com.zzz.tutorial.firecode;

import java.util.LinkedList;
import java.util.Queue;

public class IsBSTIterative {

    public static boolean validateBSTItr(TreeNode root) {
        if(root == null) return false;

        Queue<Node> queue = new LinkedList<>();
        Node newNode = new Node(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        Node temp, leftNode, rightNode;
        queue.offer(newNode);
        while(!queue.isEmpty()){
            temp = queue.poll();
            if(temp.node == null) continue; // Don't need to check for the leaf nodes
            if(!validateTemp(temp))
                return false;
            leftNode = new Node(temp.node.left, temp.minValue, temp.node.data);
            rightNode = new Node(temp.node.right, temp.node.data, temp.maxValue);
            queue.offer(leftNode);
            queue.offer(rightNode);
        }
        return true;
    }

    private static class Node {
        private TreeNode node;
        private int minValue;
        private int maxValue;

        public Node(TreeNode node, int minValue, int maxValue){
            this.node = node;
            this.minValue = minValue;
            this.maxValue = maxValue;
        }

    }

    private static boolean validateTemp(Node temp){
        if(temp == null) return false;

        TreeNode node = temp.node;
        //Check if values in temp are in between the left and right nodes and min and max values
        if(node.left != null && node.left.data > node.data)
            return false;
        if(node.right != null && node.right.data < node.data)
            return false;

        if(node.data < temp.minValue || node.data > temp.maxValue)
            return false;
        return true;
    }

    class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int data) {
            this.data = data;
        }

        TreeNode(int data, TreeNode left, TreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}
