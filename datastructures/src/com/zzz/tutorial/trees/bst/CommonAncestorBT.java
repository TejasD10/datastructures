package com.zzz.tutorial.trees.bst;

import java.util.Arrays;

import com.zzz.tutorial.trees.bst.TreeNode.Node;

/**
 * Find the common Ancestor in a Binary Tree (NON BST)
 * 
 */
public class CommonAncestorBT<E extends Comparable> {

	TreeNode<Integer> tree = new TreeNode<Integer>();

	public static void main(String[] args) {

	}

	public Node commonAncestor(E a, E b) {
		// Search if both the nodes are present in the binary tree
		Node A = search(tree.getRoot(), a);
		Node B = search(tree.getRoot(), b);

		if (A == null || B == null) {
			return null;
		}
		Node parentA = A.getParent();
		Node parentB = B.getParent();

		while (parentA != null || parentB != null) {
			if (parentA.getElement().compareTo(parentB.getElement()) == 0) {
				break;
			}
			parentA = parentA.getParent();
			parentB = parentB.getParent();
		}
		return parentA;
	}

	private Node search(Node root, E a) {
		if (root == null) {
			return null;
		}
		if (root.getElement().compareTo(a) == 0) {
			return root;
		}
		Node temp = search(root.getLeft(), a);
		if (temp == null)
			return search(root.getRight(), a);
		return temp;
	}
}
