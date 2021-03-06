package com.lzhlyle.leetcode.self.no25;

public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        // look up end node
        ListNode end = head;
        for (int i = 0; i < k; i++) {
            if (end == null) return head;
            end = end.next;
        }
        // reverse
        ListNode res = _reverse(head, end);
        head.next = reverseKGroup(end, k);
        return res;
    }

    private ListNode _reverse(ListNode start, ListNode end) {
        ListNode prev = null, curr = start, next;
        while (curr != end) {
            next = curr.next;
            // change
            curr.next = prev;
            // push
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
