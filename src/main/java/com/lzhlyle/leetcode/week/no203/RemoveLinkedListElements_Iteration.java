package com.lzhlyle.leetcode.week.no203;

public class RemoveLinkedListElements_Iteration {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        ListNode dummy = new ListNode(-1), curr = head, prev = dummy;
        prev.next = curr;
        while (curr != null) {
            if (curr.val == val) prev.next = curr.next;
            else prev = curr;
            curr = curr.next;
        }
        return dummy.next;
    }
}
