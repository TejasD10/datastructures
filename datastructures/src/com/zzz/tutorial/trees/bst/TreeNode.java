package com.zzz.tutorial.trees.bst;

import java.util.List;

import com.zzz.tutorial.trees.bst.TreeNode.Node;

public class TreeNode<E extends Comparable> {

	class Node<E extends Comparable> {
		private E element;
		private Node left;
		private Node right;
		private Node parent;

		public Node(E element, Node left, Node right, Node parent) {
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

		public String toString() {
			return element.toString();
		}
	}

	// Root for the tree

	private Node root;

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	public void insert(E element) {
		setRoot(insert(element, getRoot()));
	}

	private Node insert(E element, Node root) {
		if (root == null)
			return new Node<>(element, null, null, null);
		if (root.getElement().compareTo(element) > 0) {
			root.setLeft(insert(element, root.getLeft()));
			root.getLeft().setParent(root);
		}
		if (root.getElement().compareTo(element) < 0) {
			root.setRight(insert(element, root.getRight()));
			root.getRight().setParent(root);
		}
		return root;
	}

	public void inOrder(Node root) {
		if (root == null)
			return;
		inOrder(root.getLeft());
		System.out.print(root.getElement() + " ");
		inOrder(root.getRight());
	}

	public void insert(List<E> list) {
		for (E e : list) {
			setRoot(insert(e, root));
		}
	}
}
