package com.lzhlyle.leetcode.week.no234;

public class PalindromeLinkedList_LC_Reverse {
    // 反转前半段 O(n), O(1)
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode slow = head, fast = head;
        ListNode curr = slow, prev = null;
        while (fast != null && fast.next != null) {
            // push
            fast = fast.next.next;
            slow = slow.next;
            // reverse
            curr.next = prev;
            // push
            prev = curr;
            curr = slow;
        }

        // odd
        if (fast != null) slow = slow.next;

        // <- prev | slow ->
        ListNode back = prev;
        prev = curr;
        curr = back;
        while (back != null && slow != null) {
            if (back.val != slow.val) return false;
            // push
            slow = slow.next;
            back = back.next;
            // reverse
            curr.next = prev;
            // push
            prev = curr;
            curr = back;
        }
        return true;
    }
}
