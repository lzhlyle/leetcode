package com.lzhlyle.leetcode.recite.no19;

public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        if (head.next == null) {
            if (n == 1) return null;
            return head;
        }

        ListNode counter = head;
        int len = 1;
        while (counter.next != null && len++ > 0) counter = counter.next;
        if (n > len) return head;

        if (n == len) {
            ListNode res = head.next;
            head.next = null;
            return res;
        }

        ListNode prev = head;
        while (--len - n > 0) prev = prev.next;
        _remove(prev);
        return head;
    }

    private void _remove(ListNode prev) {
        if (prev.next == null) return;
        ListNode target = prev.next;
        prev.next = target.next;
        target.next = null;
    }
}
