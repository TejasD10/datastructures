package com.zzz.tutorial.trees.bst;

public class BSTRank<Key extends Comparable> {

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

	public BSTRank() {

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

	public int depth(Node root) {
		if (root == null)
			return 0;
		else
			return root.count;
	}

	public Node getRoot() {
		return root;
	}

	private void setRoot(Node root) {
		this.root = root;
	}

	public String toString() {
		if (root == null)
			return "";
		StringBuilder sb = new StringBuilder();
		Node temp = root;
		while (temp != null) {
			sb.append(temp);
			sb.append(" ");
		}
		return sb.toString();

	}

	public static void main(String[] args) {
		BSTRank<Integer> bst = new BSTRank<>();
		bst.insert(30);
		bst.insert(20);
		bst.insert(10);
		bst.insert(40);
		bst.insert(50);
		bst.preOrder();

	}

	public void preOrder() {
		preOrder(getRoot());
	}

	private void preOrder(Node root) {
		if (root == null)
			return;
		System.out.print(root + " ");
		preOrder(root.left);
		preOrder(root.right);
	}

	public Key floor(Key value) {
		return floor(getRoot(), value);
	}

	private Key floor(Node root, Key value) {
		if (root == null)
			return null;

		if (root.getElement().compareTo(value) == 0) {
			return (Key) root.getElement();
		}
		if (value.compareTo(root.getElement()) < 0)
			return floor(root.getLeft(), value);

		// Find the minimum value which is <= key, if not return current root

		Key temp = floor(root.getRight(), value);
		if (temp != null)
			return temp;
		else
			return (Key) root.getElement();

	}
}
