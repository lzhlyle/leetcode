package com.lzhlyle.leetcode.recite.no445;

import java.util.Stack;

public class AddTwoNumbersIi_Stack {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1.val == 0 && l2.val == 0) return new ListNode(0);

        Stack<Integer> stack = add(enStack(l1), enStack(l2));
        ListNode res = new ListNode(stack.pop()), curr = res;
        while (!stack.isEmpty()) {
            curr.next = new ListNode(stack.pop());
            curr = curr.next;
        }
        return res;
    }

    private Stack<Integer> add(Stack<Integer> s1, Stack<Integer> s2) {
        if (s1.size() > s2.size()) return add(s2, s1);
        Stack<Integer> stack = new Stack<>();
        while (!s1.isEmpty() && !s2.isEmpty()) {
            int sum = s1.pop() + s2.pop();
            if (sum < 10) stack.push(sum);
            else {
                stack.push(sum % 10);
                if (s1.isEmpty()) s1.push(1);
                else s1.push(s1.pop() + 1);
            }
        }
        while (!s1.isEmpty()) stack.push(s1.pop());
        while (!s2.isEmpty()) stack.push(s2.pop());
        return stack;
    }

    private Stack<Integer> enStack(ListNode node) {
        Stack<Integer> stack = new Stack<>();
        ListNode curr = node;
        while (curr != null) {
            stack.push(curr.val);
            curr = curr.next;
        }
        return stack;
    }
}
