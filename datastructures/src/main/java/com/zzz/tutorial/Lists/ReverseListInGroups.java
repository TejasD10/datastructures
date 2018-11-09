package com.zzz.tutorial.Lists;

public class ReverseListInGroups {

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

    private Node head;

    public Node reverseList(Node start, int k) {
        if (start == null)
            return start;

        // 1 -> 2 -> 3 -> 4 -> 5 -> 6
        Node prev = null, curr = start, next = start.next;
        int count = 0; // Keep the count of how many times is the reversal performed
        while (next != null && count < k - 1) {
            curr.next = prev;
            prev = curr;
            curr = next;
            next = next.next;
            count++;
        }
        // Need the last swap
        curr.next = prev;
        if (next != null)
            start.next = reverseList(next, k);
        return curr; // curr becomes the new start
    }

    /**
     * This method will call the reverseList to reverse the list
     * in groups of K
     */
    public void reverseInGroups(int k) {
        if (this.head == null)
            return; // Nothing to reverse
        // If k is less than the count of the list
        // it is allright as it should work as a normal list reversal
        this.head = reverseList(this.head, 3);
    }

    public static void main(String args[]) {
        ReverseListInGroups rl = new ReverseListInGroups();
        rl.head = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, new Node(6, null))))));
        rl.reverseInGroups(3);
        Node temp = rl.head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

    }
}
