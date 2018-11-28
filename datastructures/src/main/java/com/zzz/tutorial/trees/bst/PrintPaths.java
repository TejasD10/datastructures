package com.zzz.tutorial.trees.bst;

import java.util.ArrayList;
import java.util.Arrays;

import com.zzz.tutorial.trees.bst.TreeNode.Node;

public class PrintPaths {
	public static void main(String[] args) {
		TreeNode<Integer> tree = new TreeNode<>();
		tree.insert(Arrays.asList(8, 4, 2, 6, 5, 10, 9, 12));

		// printPaths(new ArrayList<Integer>(), 0, tree.getRoot(), 19); // 18 is
		// the
		// desired
		// sum

		printPaths2(new ArrayList<Integer>(), tree.getRoot(), 19);

	}
	
	/**
	 * This is more naive version where each node is traversed more than once
	 * O(n^2)
	 * @param list
	 * @param sum
	 * @param root
	 * @param N
	 */
	public static void printPaths(ArrayList<Integer> list, int sum, Node root, int N) {
		if (root == null)
			return;
		sum += (int) root.getElement();
		list.add((int) root.getElement());
		if (sum == N) {
			print(list);
		}
		printPaths(list, sum, root.getLeft(), N);
		printPaths(list, sum, root.getRight(), N);
		list.remove(root.getElement()); // Remove the item after it's left and
										// right trees are traversed.

		// Start to see if there is a sum starting from this node.

		printPaths(new ArrayList<Integer>(), 0, root.getLeft(), N);
		printPaths(new ArrayList<Integer>(), 0, root.getRight(), N);

	}

	/**
	 * This is a more optimal solution to printing the paths of a tree that leads to the sum.
	 * O(n)
	 * @param list
	 * @param root
	 * @param N
	 */
	public static void printPaths2(ArrayList<Integer> list, Node root, int N) {
		if (root == null)
			return;

		list.add((int) root.getElement());
		printPaths2(list, root.getLeft(), N);
		printPaths2(list, root.getRight(), N);

		int f = 0;
		for (int j = list.size() - 1; j >= 0; j--) {
			f += list.get(j);
			if (f == N)
				print(list, j);
		}
		list.remove(root.getElement());
	}

	private static void print(ArrayList<Integer> list) {
		for (Integer temp : list) {
			System.out.print(temp + " ");
		}
		System.out.println();// Blank line for next possible path
	}

	private static void print(ArrayList<Integer> list, int k) {
		for (int i = k; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println();// Blank line for next possible path
	}

}
