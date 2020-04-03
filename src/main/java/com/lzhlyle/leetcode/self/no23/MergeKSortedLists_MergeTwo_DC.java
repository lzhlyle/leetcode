package com.lzhlyle.leetcode.self.no23;

public class MergeKSortedLists_MergeTwo_DC {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int li, int ri) {
        if (li >= ri) return lists[li];
        int mid = li + ((ri - li) >> 1);
        return mergeTwo(merge(lists, li, mid), merge(lists, mid + 1, ri));
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
