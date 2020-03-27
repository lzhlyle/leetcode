package com.lzhlyle.leetcode.recite.no160;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoLinkedLists_LC_TwoPoints {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode a = headA, b = headB;
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }
}
