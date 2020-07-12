package com.lzhlyle.leetcode.week.no83;

public class RemoveDuplicatesFromSortedList_Iteration {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode curr = head.next, prev = head;
        while (curr != null) {
            if (curr.val == prev.val) {
                prev.next = curr = curr.next;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
        return head;
    }
}
