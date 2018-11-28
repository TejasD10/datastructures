package com.zzz.tutorial.trees.bst;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Find the common Ancestor in a Binary Tree (NON BST)
 */
public class CommonAncestorBT<E extends Comparable> {

    private Node root = null;

    public static void main(String[] args) {
        CommonAncestorBT<Integer> tree = new CommonAncestorBT<>();
        tree.root = new Node(1, null, null, null);
        tree.insertLeft(tree.root, 2);
        tree.insertLeft(tree.root.left, 4);
        tree.insertRight(tree.root.left, 5);
        tree.insertRight(tree.root, 3);
        tree.insertLeft(tree.root.right, 6);
        tree.insertRight(tree.root.right, 7);
        tree.levelOrder();
        Node result = tree.commonAncestor(tree.root, 2, 4);
        System.out.println(result == null ? "NULL" : "\n" + result.getElement());
    }

    private void insertLeft(Node root, E data) {
        Node newNode = new Node(data, null, null, root);
        root.setLeft(newNode);
    }

    private void insertRight(Node root, E data) {
        Node newNode = new Node(data, null, null, root);
        root.setRight(newNode);
    }

    private void levelOrder() {
        if (root == null) {
            System.out.println("Empty Tree");
            return;
        }
        Queue<Node> q = new LinkedList<Node>();
        q.offer(root);
        while (!q.isEmpty()) {
            Node temp = q.poll();
            System.out.print(temp.getElement() + " ");
            if (temp.getLeft() != null)
                q.offer(temp.getLeft());
            if (temp.getRight() != null)
                q.offer(temp.getRight());
        }
    }

    public Node commonAncestor(Node root, E a, E b) {
        if (root == null)
            return null;
        if (root.getElement().compareTo(a) == 0 || root.getElement().compareTo(b) == 0)
            return root;
        Node left = commonAncestor(root.getLeft(), a, b);
        Node right = commonAncestor(root.getRight(), a, b);

        if (left != null && right != null)
            return root;
        if (left != null && right == null)
            return left;
        return right;
    }

    private Node search(Node root, E a) {
        if (root == null) {
            return null;
        }
        if (root.getElement().compareTo(a) == 0) {
            return root;
        }
        Node temp = search(root.getLeft(), a);
        if (temp == null)
            return search(root.getRight(), a);
        return temp;
    }

    private static class Node<E extends Comparable> {
        E element;
        Node left;
        Node right;
        Node parent;

        Node(E element, Node left, Node right, Node parent) {
            this.element = element;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Node getParent() {
            return parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }
    }
}
