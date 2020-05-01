package com.lzhlyle.leetcode.week.no678;

public class ValidParenthesisString_LC_TraversalTwice {
    public boolean checkValidString(String s) {
        char[] arr = s.toCharArray();
        int l = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ')') l--;
            else l++;
            if (l < 0) return false;
        }
        if (l == 0) return true;

        int r = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == '(') r--;
            else r++;
            if (r < 0) return false;
        }
        return true;
    }
}
