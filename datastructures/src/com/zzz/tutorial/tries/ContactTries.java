package com.zzz.tutorial.tries;

import java.util.Scanner;

/**
 * 	We're going to make our own Contacts application! The application must perform two types of operations:
 * 	add name, where is a string denoting a contact name. This must store as a new contact in the application.
 * 	find partial, where is a string denoting a partial name to search the application for. It must count the number of contacts starting with and print the count on a new line.
 *	Given sequential add and find operations, perform each operation in order.
 */
public class ContactTries {

	private Trienode root = null;

	/**
	 * Since the internal Trienode is using an array of 26 letters, this offset will be used to find
	 * the right index at which to look if there is an element present.
	 */
	private static final int OFFSET = 97;

	public ContactTries() {
		root = new Trienode(false);
	}

	public static class Trienode {

		/*
		 * private static enum WordComplete { TRUE, FALSE };
		 */
		/**
		 * Checks if the word is complete
		 */
		private boolean isComplete;

		/**
		 * Stores the number of words starting from 
		 */
		private int size = 0;

		private Trienode[] nodes = new Trienode[26];

		public Trienode(boolean isComplete) {
			this.isComplete = isComplete;
		}

		public boolean getIsComplete() {
			return isComplete;
		}

		public void setIsComplete(boolean isComplete) {
			this.isComplete = isComplete;
		}

		public Trienode[] getNodes() {
			return nodes;
		}

		public void setNodes(Trienode[] nodes) {
			this.nodes = nodes;
		}

		public String toString() {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < nodes.length; i++) {
				if (nodes[i] != null) {
					sb.append(String.valueOf(((char) (OFFSET + i))));
					//sb.append(" " + nodes[i].getSize() + " ");
				}
			}
			sb.append(getSize());
			return sb.toString();
		}

		public int getSize() {
			return size;
		}

		public void setSize(int size) {
			this.size = size;
		}

	}

	public void insert(String input) {
		if (input == null || input.trim().equals(""))
			return;
		Trienode node = root;
		for (int i = 0; i < input.length(); i++) {
			node = insert(input.charAt(i), node);
		}
		node.setIsComplete(true);
	}

	private Trienode insert(char ch, Trienode temp) {
		// If there is no entry with this character in the trie
		if (temp.getNodes()[ch - OFFSET] == null) {
			temp.getNodes()[ch - OFFSET] = new Trienode(false);
		}
		temp.getNodes()[ch - OFFSET].setSize(1 + temp.getNodes()[ch - OFFSET].getSize());
		return temp.getNodes()[ch - OFFSET];
	}

	public int find(String ch) {
		if (ch == null || ch.trim().equals(""))
			return 0;
		Trienode temp = root;
		for (int i = 0; i < ch.length(); i++) {
			if (temp != null && temp.getNodes()[ch.charAt(i) - OFFSET] != null) {
				temp = temp.getNodes()[ch.charAt(i) - OFFSET];
			} else {
				temp = null;
			}
		}
		if (temp == null)
			return 0;
		else {
			return temp.getSize();
		}
	}

	private Trienode find(char ch, Trienode temp) {
		if (temp == null)
			return null;
		if (temp.getNodes()[ch - OFFSET] == null) {
			return null;
		}
		return temp;
	}

	public Trienode getRoot() {
		return root;
	}

	public void setRoot(Trienode root) {
		this.root = root;
	}

	public static void main(String[] args) {
		ContactTries trie = new ContactTries();
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for (int a0 = 0; a0 < n; a0++) {
			String op = in.next();
			String contact = in.next();
			if (op != null && op.trim().equalsIgnoreCase("add"))
				trie.insert(contact);
			if (op != null && op.trim().equalsIgnoreCase("find"))
				System.out.println(trie.find(contact));
		}
	}
}
