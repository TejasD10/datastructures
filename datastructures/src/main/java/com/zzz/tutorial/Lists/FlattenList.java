package com.zzz.tutorial.Lists;

public class FlattenList {
	private static final class Node {
		Object value;
		Node next;
		Node prev;
		Node child;
		
		public Node(Object value, Node next, Node prev, Node child){
			this.value = value;
			this.next = next;
			this.prev = prev;
			this.child = child;
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

		public Node getPrev() {
			return prev;
		}

		public void setPrev(Node prev) {
			this.prev = prev;
		}

		public Node getChild() {
			return child;
		}

		public void setChild(Node child) {
			this.child = child;
		}
		
	}
	
	private Node head;
	
	public FlattenList(){
		
	}
	
	public void add(Object value){
		
	}
}
