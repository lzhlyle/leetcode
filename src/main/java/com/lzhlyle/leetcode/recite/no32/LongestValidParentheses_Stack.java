package com.lzhlyle.leetcode.recite.no32;

import java.util.Stack;

public class LongestValidParentheses_Stack {
    // index stack
    public int longestValidParentheses(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length, max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < len; i++) {
            if (arr[i] == '(') stack.push(i);
            else {
                stack.pop();
                if (stack.isEmpty()) stack.push(i);
                else max = Math.max(max, i - stack.peek());
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int res = new LongestValidParentheses_Stack().longestValidParentheses("()");
        System.out.println(res);

    }
}
