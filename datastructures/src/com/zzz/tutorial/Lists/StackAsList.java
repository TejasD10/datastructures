package com.zzz.tutorial.Lists;

/**
 * 
 * Implementing Stack as a List Stack - LIFO LinkedList Insert - O(1) Delete -
 * O(n) Search - O(n)
 *
 */

public class StackAsList implements StackForList {

	// Head to the linkedList
	private Node head;
	// Maintain the size of the list
	int size = 0;

	public StackAsList() {
		head = null;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public int size() {
		return size;
	}

	private final static class Node {
		Object value;
		Node next;

		public Node(Object value, Node next) {
			this.value = value;
			this.next = next;
		}

		public Object getValue() {
			return value;
		}

		public void setValue(Object value) {
			this.value = value;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

	}

	@Override
	public boolean push(StackAsList stack, Object value) {
		Node newNode = new Node(value, null);
		if (stack.getHead() == null) {
			head = newNode;
		} else {
			newNode.setNext(head);
			head = newNode;
		}
		size++;
		return true;
	}

	@Override
	public Object pop() {
		if (this.getHead() == null || this.isEmpty())
			return null;
		Object temp = head.getValue();
		head = head.getNext();
		return temp;
	}

	public Node getHead() {
		return head;
	}

	public static void main(String[] args) {
		StackAsList stack = new StackAsList();

		System.out.println("INIT.. STACK");
		stack.push(stack, 10);
		stack.push(stack, 20);
		stack.push(stack, 30);
		stack.push(stack, 40);
		System.out.println(stack);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}

	public String toString() {
		if (head == null || isEmpty())
			return "";
		StringBuilder sb = new StringBuilder();
		Node temp = head;
		while (temp != null) {
			sb.append(temp.getValue());
			sb.append(" ");
			temp = temp.getNext();
		}
		return sb.toString();
	}
}
