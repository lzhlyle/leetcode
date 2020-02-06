package com.lzhlyle.leetcode.tomorrow.no24;

public class SwapNodesInPairs_Recursion {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode n = head.next;
        head.next = swapPairs(n.next); // head|n -> ...
        n.next = head; // n -> head -> ...
        return n;
    }
}
