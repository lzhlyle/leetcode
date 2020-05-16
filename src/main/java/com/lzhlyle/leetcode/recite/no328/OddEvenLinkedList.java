package com.lzhlyle.leetcode.recite.no328;

public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode evenHead = head.next, even = evenHead, odd = head;
        while (even != null && even.next != null) {
            odd = odd.next = even.next;
            even = even.next = odd.next;
        }
        odd.next = evenHead;
        return head;
    }
}
