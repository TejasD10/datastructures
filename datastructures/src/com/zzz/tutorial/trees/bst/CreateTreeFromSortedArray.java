package com.zzz.tutorial.trees.bst;

//@formatter:off
/**
 * Given a sorted array, create a binary tree with
 * minimal height
 * 
 */
//@formatter:on
public class CreateTreeFromSortedArray<E extends Comparable> {
	private static class Node<E extends Comparable> {
		E element;
		Node left;
		Node right;

		Node(E element, Node left, Node right) {
			this.element = element;
			this.left = left;
			this.right = right;
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

	}

	private Node root = null;

	public void insert(E elem) {
		setRoot(insert(elem, root));
	}

	private Node insert(E elem, Node root) {
		if (root == null)
			return new Node(elem, null, null);
		if (root.getElement().compareTo(elem) > 0) {
			root.setLeft(insert(elem, root.left));
		}
		if (root.getElement().compareTo(elem) < 0) {
			root.setRight(insert(elem, root.right));
		}
		return root;
	}

	public void inOrder(Node root) {
		if (root == null) {
			return;
		}
		inOrder(root.getLeft());
		System.out.print(root.getElement() + " ");
		inOrder(root.getRight());
	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	public static void main(String[] args) {
		int[] input = { 1, 2, 3, 4, 5, 6 };
		CreateTreeFromSortedArray<Integer> tree = new CreateTreeFromSortedArray<>();
		tree.setRoot(tree.createTree(input));
		tree.inOrder(tree.getRoot());
	}

	public Node createTree(int[] input) {
		return createTree(input, 0, input.length - 1);
	}

	private Node createTree(int[] input, int lo, int hi) {
		if (lo > hi)
			return null;
		int mid = (lo + hi) / 2;
		Node newNode = new Node(input[mid], null, null);
		newNode.setLeft(createTree(input, lo, mid - 1));
		newNode.setRight(createTree(input, mid + 1, hi));
		return newNode;
	}

}
