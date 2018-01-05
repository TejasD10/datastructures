package com.zzz.tutorial.Lists;

/**
 * Given a singly linked list, delete the nth node from the list.
 */
public class DeleteNthNode {

    private Node head = null;

    public static void main(String args[]) {
        DeleteNthNode list = new DeleteNthNode();
        list.head = new Node(10, null);
        list.head.next = new Node(20, null);
        list.head.next.next = new Node(30, null);
        list.head.next.next.next = new Node(40, null);
        list.printList();
        System.out.println(); // Blank Line
        list.deleteNthNode(0);
        list.printList();
    }

    public void printList() {
        if (head == null)
            return;
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public void deleteNthNode(int n) {
        //Delete Head?
        if (n == 0) {
            head = head.next;
            return;
        }

        //Go to the Nth node
        Node temp = head;
        Node prev = head;

        int i;
        for (i = 0; i < n; i++) {
            if (i > 0)
                prev = prev.next;
            if (temp.next == null)
                break;
            temp = temp.next;
        }
        //n is greater than the size of the linked list
        if (i < n) {
            System.out.println("N is too large");
            return;
        }
        if (temp.next == null)
            prev.next = null;
        else
            prev.next = temp.next;
    }

    private static class Node {
        int data;
        Node next;

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public String toString() {
            return String.valueOf(data);
        }
    }
}
