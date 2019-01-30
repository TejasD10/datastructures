package com.zzz.tutorial.firecode;

public class FindNthNode {
    static class ListNode {
        int data;
        ListNode next;

        ListNode(int data) {
            this.data = data;
        }
    }

    public static ListNode findNthNodeFromEnd(ListNode head, int n) {
        // Add your code below this line. Do not modify any other code.
        ListNode previous = head;
        while (head != null) {
            if (n <= 0) {
                previous = previous.next;
            }
            n--;
            head = head.next;
        }
        return n <= 0 ? previous : null;
        // Add your code above this line. Do not modify any other code.
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        System.out.println(findNthNodeFromEnd(head, 2).data);
    }
}
