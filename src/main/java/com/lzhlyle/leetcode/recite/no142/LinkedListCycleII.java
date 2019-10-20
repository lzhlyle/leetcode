package com.lzhlyle.leetcode.recite.no142;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycleII {
    // 暴力解
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) return head;
            set.add(head);
            head = head.next;
        }
        return null;
    }
}
