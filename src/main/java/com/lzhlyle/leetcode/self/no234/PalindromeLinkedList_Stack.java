package com.lzhlyle.leetcode.self.no234;

import java.util.Stack;

public class PalindromeLinkedList_Stack {
    // O(n), O(n)
    public boolean isPalindrome(ListNode head) {
        int n = 0;
        ListNode curr = head;
        while (curr != null) {
            n++;
            curr = curr.next;
        }

        Stack<Integer> stack = new Stack<>();
        ListNode valid = head;
        int i = 0, mid = (n + 1) >> 1;
        while (valid != null) {
            i++;
            if (i < mid) stack.push(valid.val);
            if (i == mid && (n & 1) == 0) stack.push(valid.val);
            if (i > mid) {
                if (stack.pop() != valid.val) return false;
            }
            valid = valid.next;
        }
        return true;
    }
}
