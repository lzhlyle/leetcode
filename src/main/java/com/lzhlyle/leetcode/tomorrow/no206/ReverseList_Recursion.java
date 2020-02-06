package com.lzhlyle.leetcode.tomorrow.no206;

public class ReverseList_Recursion {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next== null) return head;
        ListNode res = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return res;
    }
}
