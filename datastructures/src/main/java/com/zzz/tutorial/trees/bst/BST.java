package com.zzz.tutorial.trees.bst;

public class BST<K extends Comparable> {
	private static final class Node<Key extends Comparable<Key>> {
		Node left;
		Key key;
		Node right;

		public Node(Key key, Node left, Node right) {
			this.key = key;
			this.left = left;
			this.right = right;

		}

		public Node getLeft() {
			return left;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public Object getKey() {
			return key;
		}

		public void setKey(Key key) {
			this.key = key;
		}

		public Node getRight() {
			return right;
		}

		public void setRight(Node right) {
			this.right = right;
		}

		public int compareTo(Object o) {
			return key.compareTo((Key)o);
		}

	}

	private Node root;

	public BST() {

	}

	// Insert
	public void insert(K value) {
		setRoot(insert(root, value));
	}

	private Node insert(Node root, K value) {
		// Check if the tree is empty
		if (root == null)
			return new Node(value, null, null);

		// Left tree
		if (value.compareTo(root.getKey()) < 0)
			root.setLeft(insert(root.getLeft(), value));
		//Right tree
		if(value.compareTo(root.getKey()) > 0)
			root.setRight(insert(root.getRight(), value));
		
		return root;
		
	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}
	
	/**
	 * InOrder traversal of the tree
	 */
	
	public void inOrder(){
		inOrder(root);
	}
	
	private void inOrder(Node root){
		if(root == null) return;
		inOrder(root.getLeft());
		System.out.print(root.getKey() + " ");
		inOrder(root.getRight());
	}
	
	public void preOrder(){
		preOrder(root);
	}
	private void preOrder(Node root){
		if(root == null) return;
		System.out.print(root.getKey() + " ");
		preOrder(root.getLeft());
		preOrder(root.getRight());
	}
	public static void main(String[] args) {
		BST<Integer> tree = new BST<Integer>();
		tree.insert(30);
		tree.insert(20);
		tree.insert(10);
		System.out.println("In Order");
		tree.inOrder();
		
		System.out.println("\nPre Order");
		tree.preOrder();
	}
}
