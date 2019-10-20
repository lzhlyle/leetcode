package com.lzhlyle.leetcode.recite.no141;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        // 暴力解 Time: `$O(n)$`, Space: `$O(n)$`
        if (head == null || head.next == null) return false;

        Set<ListNode> set = new HashSet<>();
        ListNode node = head;
        while (node.next != null) {
            if (set.contains(node)) {
                return true;
            }

            set.add(node);
            node = node.next;
        }
        return false;
    }
}
