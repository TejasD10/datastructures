package com.zzz.tutorial.trees.bst;

import java.util.Arrays;

import com.zzz.tutorial.trees.bst.TreeNode.Node;

/**
 * 
 * Find hte
 *
 */
public class InOrderSuccessor<E extends Comparable> {
	public static void main(String[] args) {
		TreeNode<Integer> tree = new TreeNode<>();
		tree.insert(Arrays.asList(20, 8, 22, 4, 12, 10, 14));
		// tree.inOrder(tree.getRoot());
		Node result = inOrderSuccessor(8, tree.getRoot());
		result = inOrderSuccessor(result);
		System.out.println(result == null ? "null" : result.getElement());
	}

	public static Node inOrderSuccessor(int n, Node root) {
		if (root == null)
			return null;
		if (root.getElement().compareTo(n) < 0)
			return inOrderSuccessor(n, root.getRight());
		if (root.getElement().compareTo(n) > 0)
			return inOrderSuccessor(n, root.getLeft());
		return root;
	}

	public static Node inOrderSuccessor(Node root) {
		if (root == null)
			return null;
		// Check if the root.right is present
		if (root.getRight() != null) {
			Node temp = root.getRight();
			while (temp.getLeft() != null) {
				temp = temp.getLeft();
			}
			return temp;
		}
		Node temp = root;
		Node p = null;
		while (temp != null) {
			p = temp.getParent();
			if (p != null && p.getLeft() == temp)
				break;
			temp = p;
		}
		return p;
	}

}
