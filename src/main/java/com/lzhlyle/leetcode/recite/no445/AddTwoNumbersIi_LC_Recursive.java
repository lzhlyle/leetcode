package com.lzhlyle.leetcode.recite.no445;

public class AddTwoNumbersIi_LC_Recursive {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1 = len(l1), len2 = len(l2);

        ListNode head = new ListNode(1);
        head.next = add(l1, l2, len1 - len2);

        if (head.next.val > 9) {
            head.next.val %= 10;
            return head;
        }
        return head.next;
    }

    // len(n1) > len(n2)
    private ListNode add(ListNode n1, ListNode n2, int delta) {
        if (delta < 0) return add(n2, n1, -delta);
        if (n1 == null) return null;

        ListNode res = delta == 0 ? new ListNode(n1.val + n2.val) : new ListNode(n1.val);
        ListNode post = delta == 0 ? add(n1.next, n2.next, 0) : add(n1.next, n2, delta - 1);

        if (post != null && post.val > 9) {
            res.val += 1;
            post.val %= 10;
        }

        res.next = post;
        return res;
    }

    private int len(ListNode node) {
        int len = 0;
        ListNode curr = node;
        while (curr != null) {
            len++;
            curr = curr.next;
        }
        return len;
    }
}
