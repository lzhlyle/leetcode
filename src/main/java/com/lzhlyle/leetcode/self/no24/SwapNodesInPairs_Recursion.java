package com.lzhlyle.leetcode.self.no24;

public class SwapNodesInPairs_Recursion {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode n = head.next;
        head.next = swapPairs(n.next);
        n.next = head;
        return n;
    }
}
