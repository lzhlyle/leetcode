package com.lzhlyle.leetcode.week.no678;

import java.util.Stack;

public class ValidParenthesisString_LC_TwoStacks {
    public boolean checkValidString(String s) {
        Stack<Integer> left = new Stack<>(), star = new Stack<>(); // index stack
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') left.push(i);
            else if (c == '*') star.push(i);
            else {
                if (!left.isEmpty()) left.pop();
                else if (!star.isEmpty()) star.pop();
                else return false;
            }
        }

        while (!left.isEmpty() && !star.isEmpty()) {
            if (left.pop() > star.pop()) return false;
        }
        return left.isEmpty();
    }
}
