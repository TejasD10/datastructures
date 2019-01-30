package com.zzz.tutorial.firecode;

public class InsertIntoDoubly {
    private static class DoublyLinkedNode {
        int data;
        DoublyLinkedNode next;
        DoublyLinkedNode prev;

        public DoublyLinkedNode(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "" + this.data;
        }
    }

    public static DoublyLinkedNode insertAtPos(DoublyLinkedNode head, int data, int pos) {
        if (pos == 0) return head;

        // insert at head
        if (pos == 1) {
            if (head == null) {
                head = new DoublyLinkedNode(data);
                head.next = null;
                head.prev = null;
            } else {
                DoublyLinkedNode newNode = createNode(data);
                newNode.next = head;
                newNode.prev = null;
                head.prev = newNode;
                head = newNode;
            }
        } else { // insert in the middle or at the end
            int count = 1;
            DoublyLinkedNode temp = head;
            while (temp.next != null) {
                if (count == pos) {
                    // Found the node
                    DoublyLinkedNode newNode = createNode(data);
                    newNode.prev = temp.prev;
                    newNode.next = temp;
                    temp.prev.next = newNode;
                    temp.prev = newNode;
                    return head;
                }
                temp = temp.next;
                count++;
            }
            if (count + 1 == pos) { // Add it as the last element
                DoublyLinkedNode newNode = createNode(data);
                temp.next = newNode;
                newNode.prev = temp;
                newNode.next = null;
            }
        }
        return head;
    }

    private static DoublyLinkedNode createNode(int data) {
        return new DoublyLinkedNode(data);
    }

    private static void print(DoublyLinkedNode head) {
        DoublyLinkedNode temp = head;
        while (temp != null) {
            System.out.println(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        DoublyLinkedNode head = new DoublyLinkedNode(1);
        head.next = new DoublyLinkedNode(2);
        head.next.next = new DoublyLinkedNode(3);
        head = insertAtPos(head, 4, 2);
        print(head);
    }
}
