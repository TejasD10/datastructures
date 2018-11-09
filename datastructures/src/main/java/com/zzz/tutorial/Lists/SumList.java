package com.zzz.tutorial.Lists;

public class SumList {

    private static class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public String toString() {
            return String.valueOf(this.data);
        }
    }

    public Node createSumList(Node head1, Node head2, int carry) {
        // Create a new List with the sum
        // of the two lists
        // If both are null there are no lists
        if (head1 == null && head2 == null)
            return head1;

        int sum = (head1 == null ? 0 : head1.data) +
                (head2 == null ? 0 : head2.data) + carry;
        Node newHead = new Node(sum % 10, null);
        newHead.next = createSumList((head1 == null ? null : head1.next), (head2 == null ? null : head2.next), sum / 10);
        // Return the new node
        return newHead;
    }

    public static void main(String args[]) {
        SumList sl = new SumList();
        Node head1 = new Node(7, new Node(5, new Node(9, new Node(4, new Node(6, null)))));
        Node head2 = new Node(8, new Node(4, null));
        Node newList = sl.createSumList(head1, head2, 0);
        printList(newList);
    }

    private static void printList(Node newList) {
        Node temp = newList;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}
