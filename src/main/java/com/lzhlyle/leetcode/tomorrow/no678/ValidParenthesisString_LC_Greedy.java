package com.lzhlyle.leetcode.tomorrow.no678;

public class ValidParenthesisString_LC_Greedy {
    public boolean checkValidString(String s) {
        // possible range
        int min = 0, max = 0; // 维护当前左括号的数量范围：[min, max]
        for (char c : s.toCharArray()) {
            if (c == '(') {
                min++;
                max++;
            } else if (c == ')') {
                if (min > 0) min--;
                if (max-- == 0) return false;// 左括号不够
            } else {
                if (min > 0) min--; // 可作为右括号，抵消
                max++; // 可作为左括号
            }
        }
        return min == 0;
    }
}
