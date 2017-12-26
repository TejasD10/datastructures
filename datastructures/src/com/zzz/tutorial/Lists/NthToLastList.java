package com.zzz.tutorial.Lists;

// @formatter:off
/**
 * 
 * Implement a method NthToLast()
 * which returns the nth to last element in the list
 * If n = 0 return the last element.
 * if n > size of the list return null;
 *
 */
// @formatter:on
public class NthToLastList {

	private static final class Node {
		Object value;
		Node next;

		public Node(Object value, Node next) {
			this.value = value;
			this.next = next;
		}

		public Object getValue() {
			return this.value;
		}

		public Node getNext() {
			return this.next;
		}
	}

	// Head of the Linked list
	private Node head;

	public NthToLastList() {

	}

	public void add(Object value) {
		Node newNode = new Node(value, null);
		if (head == null) {
			head = newNode;
			return;
		}
		Node temp = head;
		while (temp.getNext() != null)
			temp = temp.getNext();
		temp.next = newNode;
	}

	public Object remove(Object value) {
		if (head == null) {
			return null;
		}
		// Value is in head
		if (head.getValue() == value) {
			Object temp = head.getValue();
			head = head.getNext();
			return temp;
		}
		Node temp = head.getNext(), prev = head;
		while (temp != null) {
			if (temp.getValue() == value) {
				prev.next = temp.getNext();
				return temp.getValue();
			}
			prev = temp;
			temp = temp.getNext();
		}
		return null;
	}

	// @formater:off
	/**
	 * Run two pointers, set the first pointer to the Nth position of the list
	 * from starting and start the other pointer from the head Start
	 * incrementing both the pointers, once the fast pointer reaches the end,
	 * the slow pointers will be at the Nth to Last element in the list.
	 * 
	 * @param n
	 * @return
	 */
	// @formatter:on
	public Object NtoLast(int n) {
		if (n < 0)
			return null;
		// Set the fast pointer at n positions from the head
		Node fp = head;
		int i;
		for (i = 0; i <= n; i++) {
			if (fp.getNext() == null)
				break;
			fp = fp.getNext();
		}
		if (i < n)
			return null;
		Node sp = head;
		while (fp.getNext() != null) {
			fp = fp.getNext();
			sp = sp.getNext();
		}
		return sp.getValue();
	}

	public String toString() {
		if (head == null) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		Node temp = head;
		while (temp != null) {
			sb.append(temp.getValue());
			sb.append(" ");
			temp = temp.getNext();
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		NthToLastList list = new NthToLastList();
		list.add(10);
		list.add(20);
		list.add(30);
		System.out.println(list);
		// list.remove(20);
		// System.out.println(list);
		System.out.println(list.NtoLast(2));
	}
}
