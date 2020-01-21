package com.lzhlyle.leetcode.week.no142;

public class LinkedListCycleII {
    // 快慢指针: 2(a + b) = a + b + c + b; => a = c;
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;

        ListNode fast = head, slow = head, meet = null;
        while (fast != null && fast.next != null && meet == null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) meet = slow;
        }

        if (meet == null) return null;

        ListNode again = head;
        while (again != meet) {
            again = again.next;
            meet = meet.next;
        }
        return meet;
    }
}