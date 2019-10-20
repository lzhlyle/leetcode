package com.lzhlyle.leetcode.self.no141;

public class LinkedListCycle_2 {
    public boolean hasCycle(ListNode head) {
        // 快慢指针 Time: `$O(n)$`, Space: `$O(1)$`
        if (head == null || head.next == null) return false;

        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != slow) {
            if (fast.next == null || fast.next.next == null) return false;
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }
}
