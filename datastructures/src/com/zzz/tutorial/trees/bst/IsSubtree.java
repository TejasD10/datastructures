package com.zzz.tutorial.trees.bst;

import java.util.Arrays;

import com.zzz.tutorial.trees.bst.TreeNode.Node;

public class IsSubtree {
	public static void main(String[] args) {
		TreeNode<Integer> tree1 = new TreeNode<>();
		TreeNode<Integer> tree2 = new TreeNode<>();

		tree1.insert(Arrays.asList(10, 6, 3, 8, 7, 9, 12, 11, 14, 13));
		tree2.insert(Arrays.asList(1,2,3));

		System.out.println(isSubtree(tree1.getRoot(), tree2.getRoot()));
	}

	public static boolean isSubtree(Node t1, Node t2) {
		if (t1 == null && t2 == null)
			return true;
		if (t1 == null || t2 == null)
			return false;
		Node temp = search(t1, t2);

		if (temp == null)
			return false;

		return isSubtreeHelper(temp, t2);
	}

	private static boolean isSubtreeHelper(Node t1, Node t2) {
		if (t1 == null && t2 == null)
			return true;
		if (t1 == null || t2 == null)
			return false;
		if (t1.getElement().compareTo(t2.getElement()) != 0)
			return false;
		return (isSubtreeHelper(t1.getLeft(), t2.getLeft()) || isSubtreeHelper(t1.getRight(), t2.getRight()));
	}

	private static Node search(Node t1, Node t2) {
		if (t1 == null || t2 == null)
			return null;
		// Assuming a BST
		if (t2.getElement().compareTo(t1.getElement()) > 0)
			return search(t1.getRight(), t2);
		if (t2.getElement().compareTo(t1.getElement()) < 0)
			return search(t1.getLeft(), t2);

		return t1;
	}
}
