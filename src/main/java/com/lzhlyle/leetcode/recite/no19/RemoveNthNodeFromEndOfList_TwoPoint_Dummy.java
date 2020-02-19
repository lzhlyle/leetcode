package com.lzhlyle.leetcode.recite.no19;

public class RemoveNthNodeFromEndOfList_TwoPoint_Dummy {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // fast
        ListNode fast = dummy;
        for (int distance = 0; distance <= n; distance++) {
            fast = fast.next;
        }

        // slow
        ListNode slow = dummy;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // remove
        slow.next = slow.next.next;
        return dummy.next;
    }
}
