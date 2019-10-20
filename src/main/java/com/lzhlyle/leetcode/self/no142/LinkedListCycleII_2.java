package com.lzhlyle.leetcode.self.no142;

public class LinkedListCycleII_2 {
    // 快慢指针，F=b
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;

        // find meet node
        ListNode slow = head;
        ListNode fast = head;
        do {
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
        } while (slow != fast);

        // find entrance node
        ListNode meet = slow;
        ListNode again = head;
        while (meet != again) {
            meet = meet.next;
            again = again.next;
        }
        return again;
    }
}