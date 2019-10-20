package com.lzhlyle.leetcode.self.no142;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycleII {
    // 暴力解
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;

        Set<ListNode> memo = new HashSet<>();
        ListNode node = head;
        while (node != null) {
            if (memo.contains(node)) return node;
            memo.add(node);
            node = node.next;
        }
        return null;
    }
}
