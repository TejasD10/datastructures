package com.zzz.tutorial.stacks;

import java.util.Scanner;
import java.util.Stack;

public class TaleOfTwo {
	public static class MyQueue<T> {
		Stack<T> stackNewestOnTop = new Stack<T>();
		Stack<T> stackOldestOnTop = new Stack<T>();
		private T TOP;

		public void enqueue(T value) { // Push onto newest stack
			stackNewestOnTop.push(value);
			if (TOP == null)
				TOP = value;
		}

		public T peek() {
			if (stackNewestOnTop.empty())
				return null;
			return TOP;
		}

		public T dequeue() {
			if (stackNewestOnTop.empty())
				return null;
			while (!stackNewestOnTop.empty()) {
				stackOldestOnTop.push(stackNewestOnTop.pop());
			}
			T item = stackOldestOnTop.pop();
			if (!stackOldestOnTop.empty())
				TOP = stackOldestOnTop.peek();
			else
				TOP = null;
			while (!stackOldestOnTop.empty()) {
				stackNewestOnTop.push(stackOldestOnTop.pop());
			}
			return item;
		}
	}

	public static void main(String[] args) {
		MyQueue<Integer> queue = new MyQueue<Integer>();

		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		for (int i = 0; i < n; i++) {
			int operation = scan.nextInt();
			if (operation == 1) { // enqueue
				queue.enqueue(scan.nextInt());
			} else if (operation == 2) { // dequeue
				queue.dequeue();
			} else if (operation == 3) { // print/peek
				System.out.println(queue.peek());
			}
		}
		scan.close();
	}
}
