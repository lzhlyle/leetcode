package com.lzhlyle.leetcode.tomorrow.no141;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        // 暴力解 Time: `$O(n)$`, Space: `$O(n)$`

        if (head == null || head.next == null) return false;

        Set<ListNode> set = new HashSet<>();
        ListNode currentNode = head;
        while (currentNode.next != null) {
            if (set.contains(currentNode)) return true;
            set.add(currentNode);
            currentNode = currentNode.next;
        }
        return false;
    }
}
