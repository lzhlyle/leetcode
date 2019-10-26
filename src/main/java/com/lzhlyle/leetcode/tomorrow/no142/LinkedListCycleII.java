package com.lzhlyle.leetcode.tomorrow.no142;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycleII {
    // 暴力解
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;

        Set<ListNode> set = new HashSet<>();
        ListNode curr = head;
        while (curr.next != null) {
            if (set.contains(curr)) return curr;

            set.add(curr);
            curr = curr.next;
        }
        return null;
    }
}
