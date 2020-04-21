package com.lzhlyle.leetcode.self.no234;

public class PalindromeLinkedList_LC_Reverse {
    // 反转前半段 O(n), O(1)
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode slow = head, fast = head;
        ListNode pre = head, prepre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
            pre.next = prepre;
            prepre = pre;
        }
        if (fast != null) slow = slow.next;
        while (pre != null && slow != null) {
            if (pre.val != slow.val) return false;
            pre = pre.next;
            slow = slow.next;
        }
        // 还应反转回去
        return true;
    }
}
