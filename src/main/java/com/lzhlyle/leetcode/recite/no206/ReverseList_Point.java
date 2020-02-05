package com.lzhlyle.leetcode.recite.no206;

public class ReverseList_Point {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null, curr = head, next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            // push points
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
