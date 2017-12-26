package com.zzz.tutorial.Lists;
// @formatter:off
/**
 * Use the Floyd's algorithm to detect cycle by using
 * the fast and the slow pointers.
 * When using fast and slow pointers, they always meet at one of the loop nodes.
 * Remove the cycle by using the same algorithm.
 * @author TDesai
 *
 */
// @formatter:on

public class IsCyclicList {
	private static class Node {
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

	private Node head;

	public IsCyclicList() {
	}

	public void add(Object value) {
		Node newNode = new Node(value, null);

		if (head == null) {
			head = newNode;
			return;
		}
		Node temp = head;
		while (temp.getNext() != null) {
			temp = temp.getNext();
		}
		temp.setNext(newNode);
	}

	public boolean isCyclic() {
		if (head == null) {
			return false;
		}
		Node fp = head;
		Node sp = head;

		while (true) {
			fp = fp.getNext().getNext();
			sp = sp.getNext();

			if (fp == null || fp.getNext() == null)
				return false;
			if (fp == sp){
				System.out.println(fp.getValue());
				return true;
			}
		}
	}
	
	public String toString(){
		if(head == null){
			return "";
		}
		StringBuilder sb = new StringBuilder();
		Node temp = head;
		while(temp != null){
			sb.append(temp.getValue());
			sb.append(" ");
			temp = temp.getNext();
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		IsCyclicList list = new IsCyclicList();

		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);
		System.out.println(list);
		list.head.next.next = list.head.next;

		System.out.println(list.isCyclic());
	}
}
