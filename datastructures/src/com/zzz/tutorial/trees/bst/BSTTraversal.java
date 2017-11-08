package com.zzz.tutorial.trees.bst;

import java.util.Stack;

/**
 * 
 * Pre-Order traversal, in an iterative way.
 *
 */
public class BSTTraversal<Key extends Comparable> {
	private final static class Node<Key extends Comparable> {
		private Key element;
		private Node parent;
		private Node left;
		private Node right;
		private int count;

		public Node(Key element, Node parent, Node left, Node right, int count) {
			this.element = element;
			this.parent = parent;
			this.left = left;
			this.right = right;
			this.count = count;
		}

		public Key getElement() {
			return element;
		}

		public void setElement(Key element) {
			this.element = element;
		}

		public Node getParent() {
			return parent;
		}

		public void setParent(Node parent) {
			this.parent = parent;
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

		public String toString() {
			return new String("(" + element + ", " + count + ")");
		}

	}

	private Node root;

	public BSTTraversal() {

	}

	// Insert
	public void insert(Key value) {
		setRoot(insert(getRoot(), value));
	}

	private Node insert(Node root, Key value) {
		if (root == null)
			return new Node(value, null, null, null, 1);

		if (value.compareTo(root.getElement()) < 0)
			root.setLeft(insert(root.getLeft(), value));
		if (value.compareTo(root.getElement()) > 0)
			root.setRight(insert(root.getRight(), value));

		root.count = 1 + depth(root.left) + depth(root.right);
		return root;
	}

	private int depth(Node root) {
		if (root == null)
			return 0;
		return root.count;
	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	public void preOrderIterative(Node root) {
		if (root == null)
			return;

		Stack<Node> stack = new Stack<Node>();

		// STack the right item, so that it can be visited again
		stack.push(root.getRight());
		stack.push(root.getLeft());
		System.out.print(root.getElement() + " ");

		while (!stack.isEmpty()) {
			Node temp = stack.pop();
			if (temp != null) {
				System.out.print(temp.getElement() + " ");
				stack.push(temp.getRight());
				stack.push(temp.getLeft());
			}
		}
	}

	// In Order Iterative
	public void inOrderIterative(Node root) {
		if (root == null)
			return;
		Stack<Node> stack = new Stack<Node>();
		Node current, temp;

		current = root;

		do {
			while(current != null){
				stack.push(current);
				current = current.getLeft();
			}
			temp = stack.pop();
			System.out.print(temp.getElement() + " ");
			current = temp.getRight();

		} while (current != null || !stack.isEmpty());

	}

	public static void main(String[] args) {
		BSTTraversal<Integer> tree = new BSTTraversal<>();

		tree.insert(9);
		tree.insert(6);
		tree.insert(12);
		tree.insert(5);
		tree.insert(7);
		tree.insert(11);
		tree.insert(13);
		
		System.out.println("Pre Order");
		tree.preOrderIterative(tree.root);
		System.out.println("\nIn Order");
		tree.inOrderIterative(tree.getRoot());
	}
}
