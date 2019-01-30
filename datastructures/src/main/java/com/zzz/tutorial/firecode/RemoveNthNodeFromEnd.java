package com.zzz.tutorial.firecode;

public class RemoveNthNodeFromEnd {
    class ListNode {
        int data;
        ListNode next;
        ListNode(int data) { this.data = data; }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return head;
        if(n <= 0) return head;

        ListNode temp = head;
        ListNode prev = head;
        ListNode curr = head;
        while(temp != null){
            if(n <= 0){
                prev = curr;
                curr = curr.next;
            }
            n--;
            temp = temp.next;
        }
        if(n > 0) return head; // Did not reach the end
        if(prev == curr) head = head.next; // Remove the head node
        else prev.next = curr.next; // Remove any normal node.

        return head;
    }
}
