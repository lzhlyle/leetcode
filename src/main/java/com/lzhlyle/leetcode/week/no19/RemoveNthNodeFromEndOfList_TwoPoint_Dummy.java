package com.lzhlyle.leetcode.week.no19;

public class RemoveNthNodeFromEndOfList_TwoPoint_Dummy {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1), fast = dummy, slow = dummy;
        dummy.next = head;
        while (n-- > 0) fast = fast.next;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
