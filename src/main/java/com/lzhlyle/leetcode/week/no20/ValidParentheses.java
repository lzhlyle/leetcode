package com.lzhlyle.leetcode.week.no20;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        char[] arr = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : arr) {
            if (c == '(') stack.push(')');
            else if (c == '[') stack.push(']');
            else if (c == '{') stack.push('}');
            else {
                if (stack.isEmpty()) return false;
                if (stack.pop() != c) return false;
            }
        }
        return stack.isEmpty();
    }
}
