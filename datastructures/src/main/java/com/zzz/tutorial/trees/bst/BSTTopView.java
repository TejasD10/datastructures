package com.zzz.tutorial.trees.bst;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BSTTopView<E extends Comparable> {

	private class Node<E extends Comparable> {
		private E element;
		private Node parent;
		private Node left;
		private Node right;

		public Node(E element, Node parent, Node left, Node right) {
			this.element = element;
			this.parent = parent;
			this.left = left;
			this.right = right;
		}

		public E getElement() {
			return element;
		}

		public Node getLeft() {
			return left;
		}

		public Node getRight() {
			return right;
		}

	}

	// Class to be used only for the Top View traversal
	private class Top {
		Node node;
		int hd;

		public Top(Node node, int hd) {
			this.node = node;
			this.hd = hd;
		}

		public String toString(){
			return String.valueOf(this.node.element) + ":" + String.valueOf(hd);
		}

	}

	private Node root;

	public Node root() {
		return root;
	}

	public void insert(E value) {
		root = insert(root, value);
	}

	public Node insert(Node root, E value) {
		if (root == null) {
			return new Node(value, null, null, null);
		}

		if (root.getElement().compareTo(value) > 0) {
			root.left = insert(root.left, value);
		}

		if (root.getElement().compareTo(value) < 0) {
			root.right = insert(root.right, value);
		}

		return root;
	}

	public void inOrder(Node root) {
		if (root == null)
			return;
		inOrder(root.left);
		System.out.print(root.element + " ");
		inOrder(root.right);
	}

	public void levelOrder(Node root) {
		Queue<Node> queue = (Queue<Node>) new LinkedList<Node>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			System.out.print(node.getElement() + " ");
			if (node.left != null)
				queue.offer(node.left);
			if (node.right != null)
				queue.offer(node.right);
		}
	}

	public void topView(Node root) {
		Queue<Top> q = new LinkedList<Top>();
		Set<Integer> set = new HashSet<>();
		int hd;
		q.add(new Top(root, 0));

		while (!q.isEmpty()) {
			Top top = q.poll();
			hd = top.hd;

			if (!set.contains(hd)) {
				set.add(hd);
				System.out.print(top.node.element + " ");
			}

			if (top.node.left != null)
				q.offer(new Top(top.node.left, hd - 1));
			if (top.node.right != null)
				q.offer(new Top(top.node.right, hd + 1));
		}
	}

	public static void main(String[] args) {
		BSTTopView<Integer> tree = new BSTTopView<>();
		tree.insert(50);
		tree.insert(30);
		tree.insert(70);
		tree.insert(20);
		tree.insert(35);
		tree.insert(65);
		tree.insert(80);

		tree.inOrder(tree.root);

		System.out.println("\nLevel Order:");
		tree.levelOrder(tree.root);
		
		System.out.println("\nTop view:");
		tree.topView(tree.root);
	}

}
