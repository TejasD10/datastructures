package com.zzz.tutorial.tries;

public class ContactTries {

	private Trienode root = null;

	public ContactTries() {

	}

	public static class Trienode {
		private boolean isCompleted;
		private Trienode[] nodes = new Trienode[26];

		public Trienode(boolean isCompleted) {
			this.isCompleted = isCompleted;
		}

		private void insert(char ch) {
			
		}

	}

	public void insert(String input) {
		for (int i = 0; i < input.length(); i++) {
			insert(input.charAt(i));
		}
	}

	private void insert(char ch) {
		if (root == null) {
			root = new Trienode(false);

		}
	}

	public Trienode getRoot() {
		return root;
	}

	public void setRoot(Trienode root) {
		this.root = root;
	}
}
