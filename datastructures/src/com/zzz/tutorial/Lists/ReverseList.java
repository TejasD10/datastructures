package com.zzz.tutorial.Lists;

import java.awt.List;

/**
 * Reverse a given linked list
 * <p>
 * https://www.geeksforgeeks.org/reverse-a-linked-list/
 */
public class ReverseList {
    private static class Node {
        private int data;
        private Node next;

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public String toString() {
            return String.valueOf(data);
        }
    }

    // head of the linked list
    private Node head;

    public void print() {
        if (head == null)
            return;
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        ReverseList list = new ReverseList();
        list.head = new Node(1, null);
        list.head.next = new Node(2, null);
        list.head.next.next = new Node(3, null);
        list.head.next.next.next = new Node(0, null);
        // list.head.next.next.next.next = new Node(5, null);

        // list.print();
        // list.reverse();
        Node temp = list.reverse_recurse(list.head);
        temp.next = null;
        System.out.println();
        //System.out.println("Min = " + list.findMin());
        list.print();
    }

    /**
     * Reverse the linkedlist in an iterative way
     */
    public void reverse() {
        if (head == null)
            return;
        Node prev = null;
        Node n = head.next;
        Node curr = head;

        while (n != null) {
            curr.next = prev;
            prev = curr;
            curr = n;
            n = n.next;
        }
        curr.next = prev;
        head = curr;
    }

    /**
     * Reverse recursively
     */
    public Node reverse_recurse(Node root) {
        if(root == null) {
            return null;
        }
        if (root.next == null) {
            head = root;
            return head;
        }
        Node temp = reverse_recurse(root.next);
        temp.next = root;
        return root;
    }

    /**
     * Find minimum element from the list in O(n)
     */
    private int findMin() {
        if (head == null)
            return -1;
        int min = head.data;

        Node temp = head;
        while (temp != null) {
            if (min > temp.data)
                min = temp.data;
            temp = temp.next;
        }
        return min;
    }
}
