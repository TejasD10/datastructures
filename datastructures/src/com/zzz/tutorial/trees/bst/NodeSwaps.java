package com.zzz.tutorial.trees.bst;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class NodeSwaps {

	private Node root;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		NodeSwaps tree = new NodeSwaps();
		tree.root = new Node(1, null, null);
		// Input the number of lines
		int N = in.nextInt();
		int leftValue, rightValue;
		Queue<Node> q = new LinkedList<Node>();
		q.offer(tree.root);
		for (int i = 0; i < N; i++) {
			Node temp = q.poll();
			leftValue = in.nextInt();
			rightValue = in.nextInt();
			if (leftValue != -1) {
				temp.left = new Node(leftValue, null, null);
				q.offer(temp.left);
			}
			if (rightValue != -1) {
				temp.right = new Node(rightValue, null, null);
				q.offer(temp.right);
			}
		}
		int T = in.nextInt();
		int K[] = new int[T];
		for (int i = 0; i < T; i++) {
			K[i] = in.nextInt();
		}
		for (int i = 0; i < T; i++) {
			tree.swap(tree.root, K[i]);
		}
	}

	private void swap(Node root, int k) {
		Map<Integer, List<Node>> map = new HashMap<Integer, List<Node>>();
		List<Node> list = new ArrayList<Node>();
		Queue<Node> q = new LinkedList<Node>();
		list.add(root);
		q.offer(root);

		int height = 1;
		map.put(height, list);

		while (!q.isEmpty()) {
			Node temp = q.poll();
			list = new ArrayList<Node>();
			if (temp.left != null) {
				list.add(temp.left);
				q.offer(temp.left);
			}
			if (temp.right != null) {
				list.add(temp.right);
				q.offer(temp.right);
			}
			if (!list.isEmpty())
				map.put(++height, list);
		}

		for (Map.Entry<Integer, List<Node>> entry : map.entrySet()) {
			int h = entry.getKey();
			if (h % k == 0) {
				for (Node temp : entry.getValue()) {
					swap(temp);
				}
			}
		}
		inOrder(this.root);
		System.out.println();
	}

	private void swap(Node root) {
		Node temp = root.left;
		root.left = root.right;
		root.right = temp;
	}

	private static class Node {
		int element;
		Node left, right;

		public Node(int element, Node left, Node right) {
			this.element = element;
			this.left = left;
			this.right = right;
		}

		public String toString() {
			return (element + " " + (left == null ? "" : left.element) + " " + (right == null ? "" : right.element));
		}
	}

	public void inOrder(Node root) {
		if (root == null) {
			return;
		}
		inOrder(root.left);
		System.out.print(root.element + " ");
		inOrder(root.right);
	}
}
