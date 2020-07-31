package com.lzhlyle.leetcode.self.no148;

public class SortList_MergeSort {
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }

    private ListNode mergeSort(ListNode node) {
        if (node == null || node.next == null) return node;

        // split
        ListNode p = node, pp = node, prev = null;
        while (pp != null && pp.next != null) {
            prev = p;
            p = p.next;
            pp = pp.next.next;
        }
        prev.next = null;

        ListNode l = mergeSort(node);
        ListNode r = mergeSort(p);
        return merge(l, r);
    }

    private ListNode merge(ListNode l, ListNode r) {
        if (l == null) return r;
        if (r == null) return l;

        ListNode dummy = new ListNode(-1), curr = dummy;
        while (l != null && r != null) {
            if (l.val < r.val) {
                curr = curr.next = l;
                l = l.next;
            } else {
                curr = curr.next = r;
                r = r.next;
            }
        }
        if (l != null) curr.next = l;
        if (r != null) curr.next = r;
        return dummy.next;
    }
}
