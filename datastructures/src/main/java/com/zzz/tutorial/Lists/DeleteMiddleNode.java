package com.zzz.tutorial.Lists;

/**
 * Implement an algorithm to delete a node in the middle (i.e., any node but
 * the first and last node, not necessarily the exact middle) of a singly linked list, given only access to
 * that node.
 * EXAMPLE
 * lnput:the node c from the linked list a->b->c->d->e->f
 * Result: nothing is returned, but the new linked list looks like a ->b->d- >e- >f
 */
public class DeleteMiddleNode {

    private Node head = null;
    private Node tail = null;

    public static void main(String[] args) {
        DeleteMiddleNode list = new DeleteMiddleNode();
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);
        list.insert(50);
        list.printList();
        System.out.println();
        list.deleteNode(list.search(20));
        list.printList();
    }

    private Node search(int i) {
        if (head == null)
            return null;
        Node temp = head;
        while (temp != null) {
            if (temp.data == i)
                break;
            temp = temp.next;
        }
        return temp;
    }

    public void insert(int data) {
        if (head == null) {
            head = new Node(data, null);
            tail = head;
            return;
        }
        Node newNode = new Node(data, null);
        tail.next = newNode;
        tail = newNode;
    }

    /**
     *
     * @param node - A reference to the node that needs to be deleted
     *             This cannot be the first or the last node in the linked list.
     */
    public void deleteNode(Node node) {
        if (node == null) {
            System.out.println("Invalid operation!");
            return;
        }
        if(node.next != null && node.next.next != null){
            node.data = node.next.data;
            node.next = node.next.next;
        }

    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
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
