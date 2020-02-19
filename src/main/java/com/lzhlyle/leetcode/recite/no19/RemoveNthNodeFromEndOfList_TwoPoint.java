package com.lzhlyle.leetcode.recite.no19;

public class RemoveNthNodeFromEndOfList_TwoPoint {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        if (head.next == null) {
            if (n == 1) return null;
            return head;
        }

        ListNode fast = head;
        int distance = 1;
        while (fast != null && distance < n) {
            fast = fast.next;
            distance++;
        }

        if (fast == null) return head;
        if (fast.next == null) {
            ListNode res = head.next;
            head.next = null;
            return res;
        }

        ListNode slow = head;
        while (fast.next.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        _remove(slow);
        return head;
    }

    private void _remove(ListNode prev) {
        if (prev.next == null) return;
        ListNode target = prev.next;
        prev.next = target.next;
        target.next = null;
    }
}
