package com.zzz.tutorial.Lists;

public class LinkedList<Key extends Comparable> {

	private Node head;
	private Node tail;
	int size;

	public LinkedList() {

	}

	public Node getHead() {
		return head;
	}

	public Node getTail() {
		return tail;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public void add(Key value) {
		if (head == null) {
			head = new Node(value, null);
			tail = head;
			return;
		}
		Node newNode = new Node(value, null);
		tail.setNext(newNode);
		tail = newNode;
	}

	public String toString() {
		StringBuilder build = new StringBuilder();

		Node temp = head;
		while (temp != null) {
			System.out.print(temp.getValue() + " ");
			temp = temp.getNext();
		}

		return build.toString();
	}

	private class Node<Key extends Comparable> {

		private Key value;
		private Node next;

		public Node(Key value, Node next) {
			this.value = value;
			this.next = next;
		}

		public Key getValue() {
			return value;
		}

		public void setValue(Key value) {
			this.value = value;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		public String toString() {
			return value.toString();
		}

	}
}
