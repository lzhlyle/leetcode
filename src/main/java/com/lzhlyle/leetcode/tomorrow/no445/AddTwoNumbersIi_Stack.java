package com.lzhlyle.leetcode.self.no445;

import java.util.Stack;

public class AddTwoNumbersIi_Stack {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack = add(enStack(l1), enStack(l2));
        ListNode res = new ListNode(stack.pop()), curr = res;
        while (!stack.isEmpty()) {
            curr = curr.next = new ListNode(stack.pop());
        }
        return res;
    }

    private Stack<Integer> add(Stack<Integer> s1, Stack<Integer> s2) {
        Stack<Integer> res = new Stack<>();
        int carry = 0;
        while (!s1.isEmpty() || !s2.isEmpty()) {
            int n1 = s1.isEmpty() ? 0 : s1.pop();
            int n2 = s2.isEmpty() ? 0 : s2.pop();
            int sum = n1 + n2 + carry;
            carry = sum > 9 ? 1 : 0;
            res.push(sum % 10);
        }
        if (carry > 0) res.push(carry);
        return res;
    }

    private Stack<Integer> enStack(ListNode node) {
        Stack<Integer> stack = new Stack<>();
        while (node != null) {
            stack.push(node.val);
            node = node.next;
        }
        return stack;
    }
}
