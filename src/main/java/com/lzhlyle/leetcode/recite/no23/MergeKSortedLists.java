package com.lzhlyle.leetcode.recite.no23;

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        ListNode curr = min(lists), res = curr;
        while (curr != null) {
            curr.next = min(lists);
            curr = curr.next;
        }
        return res;
    }

    // O(n)
    private ListNode min(ListNode[] lists) {
        int minIndex = -1;
        for (int i = 0, len = lists.length; i < len; i++) {
            if (lists[i] == null) continue;
            if (minIndex == -1 || lists[i].val < lists[minIndex].val) minIndex = i;
        }
        if (minIndex == -1) return null;

        ListNode res = lists[minIndex];
        lists[minIndex] = lists[minIndex].next;
        return res;
    }
}
