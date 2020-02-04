package com.lzhlyle.leetcode.self.no20;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        char[] arr = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : arr) {
            if (c == '(') stack.push(')');
            else if (c == '{') stack.push('}');
            else if (c == '[') stack.push(']');
            else {
                if (stack.isEmpty()) return false;
                if (c != stack.pop()) return false;
            }
        }
        return stack.isEmpty();
    }
}
