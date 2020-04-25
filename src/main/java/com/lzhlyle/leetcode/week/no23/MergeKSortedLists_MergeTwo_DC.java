package com.lzhlyle.leetcode.week.no23;

public class MergeKSortedLists_MergeTwo_DC {
    // O(nlog(n)), O(1)
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        return merge(lists, 0, lists.length - 1);
    }

    // T(n) = 2T(n/2) + O(k)
    private ListNode merge(ListNode[] lists, int l, int r) {
        if (l >= r) return lists[l];
        int mid = l + ((r - l) >> 1);
        ListNode a = merge(lists, l, mid);
        ListNode b = merge(lists, mid + 1, r);
        return mergeTwo(a, b);
    }

    // O(min(lenA, lenB))
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
