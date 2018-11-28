package com.zzz.tutorial.stacks;

import java.util.Scanner;
import java.util.Stack;

public class TaleOfTwo {
	public static class MyQueue<T> {
		Stack<T> stackNewestOnTop = new Stack<T>();
		Stack<T> stackOldestOnTop = new Stack<T>();

		public void enqueue(T value) { // Push onto newest stack
			stackNewestOnTop.push(value);
		}

		public T peek() {
			if (stackOldestOnTop.isEmpty() && !stackNewestOnTop.isEmpty())
				makeReady();
			return (stackOldestOnTop.isEmpty()) ? null : stackOldestOnTop.peek();
		}

		public T dequeue() {
			if (stackOldestOnTop.empty() && stackNewestOnTop.empty())
				return null;
			T item;
			if (stackOldestOnTop.empty()) {
				makeReady();
				item = stackOldestOnTop.pop();
			} else {
				item = stackOldestOnTop.pop();
			}
			return item;
		}

		private void makeReady() {
			if (!stackNewestOnTop.isEmpty()) {
				while (!stackNewestOnTop.isEmpty()) {
					stackOldestOnTop.push(stackNewestOnTop.pop());
				}
			}
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
