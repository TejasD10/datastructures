package com.zzz.tutorial.firecode;

public class ReverseList {

    public ListNode reverseList(ListNode head) {
        if (head == null) return head; // return null for an empty list

        reverseList(head, head).next = null;
        return head;
    }

    private ListNode reverseList(ListNode temp, ListNode head) {
        if (temp.next == null) {
            // Change the head
            head = temp;
            return temp;
        }
        return reverseList(temp.next, head).next = temp;
    }

    private static class ListNode {
        int data;
        ListNode next;

        ListNode(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        new ReverseList().reverseList(head);
    }
}
