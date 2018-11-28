package com.zzz.tutorial.trees.bst;

import java.util.ArrayList;
import java.util.LinkedList;

public class LevelOrderLinkedList<E extends Comparable> {
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

		public String toString() {
			return this.getElement().toString();
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

	/**
	 * The below method returns linked lists from each level
	 */
	public ArrayList<LinkedList> levelOrderLists(Node root) {
		if (root == null)
			return null;

		ArrayList<LinkedList> lists = new ArrayList<LinkedList>();
		LinkedList<Node> list = new LinkedList<Node>();
		list.add(root);
		lists.add(list);

		LinkedList iter = list;
		while (!iter.isEmpty()) {
			LinkedList<Node> newList = new LinkedList<Node>();
			for (int i = 0; i < iter.size(); i++) {
				Node temp = (Node) iter.get(i);
				if (temp.getLeft() != null)
					newList.add(temp.getLeft());
				if (temp.getRight() != null)
					newList.add(temp.getRight());
			}
			if (!newList.isEmpty())
				lists.add(newList);
			iter = newList;
		}
		return lists;
	}

	public static void main(String[] args) {
		LevelOrderLinkedList<Integer> tree = new LevelOrderLinkedList<>();
		tree.insert(10);
		tree.insert(6);
		tree.insert(15);
		tree.insert(2);
		tree.insert(8);
		tree.insert(13);
		tree.inOrder(tree.getRoot());

		ArrayList<LinkedList> lists = tree.levelOrderLists(tree.getRoot());
	}

}
