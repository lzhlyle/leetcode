package com.lzhlyle.leetcode.self.no206;

public class ReverseList_Point {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null, curr = head, next;
        while (curr != null) {
            next = curr.next;
            // move
            curr.next = prev;
            // push
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
