package com.lzhlyle.leetcode.recite.no83;

public class RemoveDuplicatesFromSortedList_Recursion {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        head.next = deleteDuplicates(head.next);
        return head.val == head.next.val ? head.next : head;
    }
}
