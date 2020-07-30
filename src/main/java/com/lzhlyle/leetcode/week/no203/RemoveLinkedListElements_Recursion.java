package com.lzhlyle.leetcode.week.no203;

public class RemoveLinkedListElements_Recursion {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }
}
