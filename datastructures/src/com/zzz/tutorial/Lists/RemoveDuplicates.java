package com.zzz.tutorial.Lists;

import java.util.HashSet;
import java.util.Set;

/**
 * Remove the duplicate nodes in a linked list.
 */
public class RemoveDuplicates {
    private Node head = null;
    private Node tail = null;

    public void insert(int data) {
        if (head == null) {
            head = new Node(data, null);
            tail = head;
        }
        Node newNode = new Node(data, null);
        tail.next = newNode;
        tail = newNode;
    }

    public void printList() {
        if (head == null)
            throw new RuntimeException("Empty List..");
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    /**
     * This method removes duplicates using a hash map and runs in linear time
     */
    public void removeDupsUsingLookup() {
        if (head == null) {
            System.out.println("List Empty!!");
            return;
        }
        Set<Integer> cache = new HashSet<>();
        Node temp = head;
        Node prev = null;
        while (temp != null) {
            if (cache.contains(temp.data)) {
                prev.next = temp.next;
            }
            cache.add(temp.data);
            prev = temp;
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
    public static void main(String args[]){
        RemoveDuplicates list = new RemoveDuplicates();
        list.insert(10);
        list.insert(20);
        list.insert(10);
        list.insert(30);
        list.insert(30);
        list.insert(40);
        list.removeDupsUsingLookup();
        list.printList();
    }
}

