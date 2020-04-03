package com.lzhlyle.leetcode.recite.no23;

public class MergeKSortedLists_MergeTwo {
    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        if (len == 0) return null;
        for (int i = 1; i < len; i++) {
            lists[i] = mergeTwo(lists[i], lists[i - 1]);
        }
        return lists[len - 1];
    }

    private ListNode mergeTwo(ListNode a, ListNode b) {
        if (a == null) return b;
        if (b == null) return a;
        if (a.val < b.val) {
            a.next = mergeTwo(a.next, b);
            return a;
        }
        b.next = mergeTwo(a, b.next);
        return b;
    }
}
