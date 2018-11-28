package com.zzz.tutorial.trees.bst;

public class IsTreeBalanced<E extends Comparable> {

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
		IsTreeBalanced<Integer> tree = new IsTreeBalanced<>();
		tree.insert(10);
		tree.insert(8);
		tree.insert(13);
		tree.insert(12);
		
		tree.inOrder(tree.getRoot());
		System.out.println("\nMax Depth: " + tree.maxDepth(tree.getRoot()));
		System.out.println("Min Depth: " + tree.minDepth(tree.getRoot()));
		System.out.println("IsBalanced: " + tree.isBalanced(tree.getRoot()));
	}

	public boolean isBalanced(Node root) {
		if (root == null)
			return true;
		return ((maxDepth(root) - minDepth(root)) <= 1);
	}

	private int maxDepth(Node root) {
		if (root == null)
			return 0;
		return (1 + Math.max(maxDepth(root.left), maxDepth(root.right)));
	}

	private int minDepth(Node root) {
		if (root == null)
			return 0;
		return (1 + Math.min(minDepth(root.left), minDepth(root.right)));

	}
}
