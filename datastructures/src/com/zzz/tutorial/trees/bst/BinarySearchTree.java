package com.zzz.tutorial.trees.bst;

public class BinarySearchTree<E extends Comparable> {

	private Node root;
	private int size;

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();

		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);

		System.out.println("Inorder Traversal: ");
		tree.inorder(tree.getRoot());
		System.out.println("\nPostORder Traversal: ");
		tree.postOrder(tree.getRoot());
		System.out.println("\nPreOrder Traversal: ");
		tree.preOrder(tree.getRoot());
	}

	private Node createNode(E element, Node parent, Node left, Node right) {
		return new Node(element, parent, left, right);
	}

	public void insert(E value) {
		setRoot(insert(root, value));
	}

	private Node insert(Node root, E value) {
		if (root == null) {
			return createNode(value, null, null, null);
		}
		if (root.getElement().compareTo(value) > 0) {
			root.setLeft(insert(root.getLeft(), value));
		}

		if (root.getElement().compareTo(value) < 0) {
			root.setRight(insert(root.getRight(), value));
		}
		return root;
	}

	public void inorder(Node root) {
		if (root == null)
			return;
		inorder(root.getLeft());
		System.out.print(root.getElement() + " ");
		inorder(root.getRight());
	}

	public void postOrder(Node root) {
		if (root == null)
			return;
		postOrder(root.getLeft());
		postOrder(root.getRight());
		System.out.print(root.getElement() + " ");
	}

	public void preOrder(Node root) {
		if (root == null)
			return;

		System.out.print(root.getElement() + " ");
		preOrder(root.getLeft());
		preOrder(root.getRight());
	}

	private class Node<E extends Comparable> {
		E element;
		Node parent;
		Node left;
		Node right;

		public Node(E element, Node parent, Node left, Node right) {
			this.element = element;
			this.parent = parent;
			this.left = left;
			this.right = right;
		}

		public E getElement() {
			return element;
		}

		public void setElement(E element) {
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
	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

}
