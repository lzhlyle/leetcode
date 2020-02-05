package com.lzhlyle.leetcode.recite.no206;

public class ReverseList_Recursion {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode res = reverseList(head.next); // 5 -> 4 -> 3|1 -> 2
        head.next.next = head; // 5 -> 4 -> 3 -> 2 <-> 1
        head.next = null; // 5 -> 4 -> 3 -> 2 -> 1 -> null
        return res;
    }
}
