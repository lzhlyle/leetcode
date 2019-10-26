package com.lzhlyle.leetcode.tomorrow.no141;

public class LinkedListCycle_2 {
    public boolean hasCycle(ListNode head) {
        // 快慢指针 Time: `$O(n)$`, Space: `$O(1)$`
        if (head == null || head.next == null || head.next.next == null) return false;

        ListNode slow = head;
        ListNode fast = head.next.next;
        while (fast.next != null && fast.next.next != null) {
            if (slow == fast) {
                return true;
            }

            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}
