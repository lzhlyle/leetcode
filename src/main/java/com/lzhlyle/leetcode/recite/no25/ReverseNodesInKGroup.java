package com.lzhlyle.leetcode.recite.no25;

public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prev = dummy, end = dummy;
        while (end.next != null) {
            // prepare start, end, nextGroup
            for (int i = 0; i < k && end != null; i++) end = end.next;
            if (end == null) break;
            ListNode start = prev.next, nextGroup = end.next;
            // split
            end.next = null;
            // reverse
            prev.next = reverseList(start);
            // link
            start.next = nextGroup;
            // push index
            end = prev = start;
        }
        return dummy.next;
    }

    private ListNode reverseList(ListNode start) {
        if (start == null || start.next == null) return start;
        ListNode res = reverseList(start.next);
        start.next.next = start;
        start.next = null;
        return res;
    }
}
