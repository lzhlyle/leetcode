package com.lzhlyle.leetcode.recite.no141;

public class LinkedListCycle_2 {
    public boolean hasCycle(ListNode head) {
        // 快慢指针 Time: `$O(n)$`, Space: `$O(1)$`
        if (head == null || head.next == null) return false;

        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != slow) {
            if (fast.next == null || fast.next.next == null) return false;

            fast = fast.next.next; // 2 steps
            slow = slow.next; // 1 step
        }
        return true;
    }
}
