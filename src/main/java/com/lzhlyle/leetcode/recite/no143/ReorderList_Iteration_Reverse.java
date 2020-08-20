package com.lzhlyle.leetcode.recite.no143;

public class ReorderList_Iteration_Reverse {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode b = reverse(slow.next); // 5->4
        slow.next = null;
        ListNode merge = head, a = head.next; // 1->2->3
        while (b != null) {
            merge = merge.next = b;
            b = b.next;

            ListNode swap = a;
            a = b;
            b = swap;
        }
    }

    private ListNode reverse(ListNode node) {
        ListNode curr = node, prev = null, next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
