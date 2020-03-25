package com.lzhlyle.leetcode.self.no32;

import java.util.Stack;

public class LongestValidParentheses_Stack {
    // index stack
    public int longestValidParentheses(String s) {
        char[] arr = s.toCharArray();
        int max = 0, len = arr.length;
        Stack<Integer> stack = new Stack<>(); // index's stack
        stack.push(-1);
        for (int i = 0; i < len; i++) {
            if (arr[i] == '(') stack.push(i);
            else {
                stack.pop();
                if (stack.isEmpty()) stack.push(i);
                max = Math.max(max, i - stack.peek());
            }
        }
        return max;
    }
}
