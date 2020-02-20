package com.lzhlyle.leetcode.tomorrow.no19;

public class RemoveNthNodeFromEndOfList_TwoPoint_Dummy {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1), fast = dummy, slow = dummy;
        dummy.next = head;
        for (int i = 0; i <= n; i++) fast = fast.next;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
