package com.lzhlyle.leetcode.tomorrow.no21;

public class MergeTwoSortedLists_Recursion {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode res;
        if (l1.val < l2.val) {
            res = l1;
            l1 = l1.next;
        } else {
            res = l2;
            l2 = l2.next;
        }
        res.next = mergeTwoLists(l1, l2);
        return res;
    }
}
