package com.lzhlyle.leetcode.tomorrow.no142;

public class LinkedListCycleII_2 {
    // 快慢指针，F=b
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return null;

        ListNode slow = head;
        ListNode fast = head;

        // find first meet node
        do {
            if (fast.next == null || fast.next.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
        } while (slow != fast);

        // run slow, meet
        ListNode meet = fast;
        ListNode again = head;
        while (again != meet) {
            again = again.next;
            meet = meet.next;
        }

        return again;
    }
}