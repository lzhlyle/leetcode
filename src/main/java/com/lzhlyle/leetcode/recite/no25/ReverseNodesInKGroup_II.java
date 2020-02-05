package com.lzhlyle.leetcode.recite.no25;

public class ReverseNodesInKGroup_II {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        // look up end range
        ListNode end = head;
        for (int i = 0; i < k; i++) {
            if (end == null) return head;
            end = end.next;
        }
        // reverse
        ListNode res = reverse(head, end);
        head.next = reverseKGroup(end, k);
        return res;
    }

    private ListNode reverse(ListNode start, ListNode end) {
        ListNode prev = null, curr = start, next;
        while (curr != end) {
            next = curr.next;
            // move
            curr.next = prev;
            // push
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
