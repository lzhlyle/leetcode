package com.lzhlyle.leetcode.week.no23;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedLists_MergeTwo_PriorityQueue {
    // priority queue O(nlog(k))
    // k = lists.length, n = all nodes count
    public ListNode mergeKLists(ListNode[] lists) {
        // O(log(k)), k = lists.length
        Queue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        for (ListNode n : lists) if (n != null) queue.add(n);
        if (queue.isEmpty()) return null;

        ListNode res = queue.remove(), curr = res;
        // O(nlog(k))
        while (!queue.isEmpty()) {
            // O(log(k))
            if (curr.next != null) queue.add(curr.next);
            curr.next = queue.remove();
            curr = curr.next;
        }
        return res;
    }
}
