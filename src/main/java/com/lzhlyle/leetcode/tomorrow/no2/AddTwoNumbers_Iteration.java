package com.lzhlyle.leetcode.tomorrow.no2;

public class AddTwoNumbers_Iteration {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1), curr = head;
        int carry = 0;
        while (l1 != null || l2 != null) {
            if (l1 == null) l1 = new ListNode(0);
            if (l2 == null) l2 = new ListNode(0);

            int n1 = l1.val, n2 = l2.val, sum = n1 + n2 + carry;
            carry = sum > 9 ? 1 : 0;

            curr = curr.next = new ListNode(sum % 10);
            l1 = l1.next;
            l2 = l2.next;
        }
        if (carry > 0) curr.next = new ListNode(carry);
        return head.next;
    }
}
