package com.lzhlyle.leetcode.self.no23;

public class MergeKSortedLists_MergeTwo_DC {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        return merge(lists, 0, lists.length - 1);
    }

    // T(n) = 2T(n/2) + O(k)
    private ListNode merge(ListNode[] lists, int li, int ri) {
        if (li >= ri) return lists[li];
        int mid = li + ((ri - li) >> 1);
        ListNode a = merge(lists, li, mid);
        ListNode b = merge(lists, mid + 1, ri);
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
