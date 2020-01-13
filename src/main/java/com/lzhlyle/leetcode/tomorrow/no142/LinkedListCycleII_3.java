package com.lzhlyle.leetcode.tomorrow.no142;

public class LinkedListCycleII_3 {
    // 快慢指针: 2(a + b) = a + b + c + b; => a = c;
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;

        ListNode fast, slow, meet = null;
        fast = slow = head;

        while (fast != null && fast.next != null && meet == null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) meet = fast;
        }

        if (meet == null) return null;

        ListNode again = head;
        while (again != meet) {
            again = again.next;
            meet = meet.next;
        }
        return again;
    }
}