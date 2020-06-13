package com.lzhlyle.leetcode.week.no2;

public class AddTwoNumbers_Recursion {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return add(l1, l2, 0);
    }

    private ListNode add(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null && carry == 0) return null;
        if (l1 == null) l1 = new ListNode(0);
        if (l2 == null) l2 = new ListNode(0);

        int n1 = l1.val, n2 = l2.val, sum = n1 + n2 + carry;
        int c = sum > 9 ? 1 : 0;

        ListNode res = new ListNode(sum % 10);
        res.next = add(l1.next, l2.next, c);
        return res;
    }
}
