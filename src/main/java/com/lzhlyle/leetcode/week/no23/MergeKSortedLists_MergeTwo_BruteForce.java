package com.lzhlyle.leetcode.week.no23;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MergeKSortedLists_MergeTwo_BruteForce {
    // O(nlog(n)), O(n)
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        List<Integer> list = new LinkedList<>();
        for (ListNode l : lists) {
            while (l != null) {
                list.add(l.val);
                l = l.next;
            }
        }
        if (list.isEmpty()) return null;

        int[] arr = new int[list.size()];
        int i = 0;
        for (Integer v : list) arr[i++] = v;
        Arrays.sort(arr); // O(nlog(n))

        int j = 0;
        ListNode res = new ListNode(arr[j++]), curr = res;
        while (j < arr.length) {
            curr.next = new ListNode(arr[j++]);
            curr = curr.next;
        }
        return res;
    }
}
