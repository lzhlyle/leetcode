package com.lzhlyle.leetcode.self.no678;

public class ValidParenthesisString_LC_TraversalTwice {
    public boolean checkValidString(String s) {
        // all * for (, valid enough or not
        int l = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '*') l++;
            else if (l-- == 0) return false;
        }
        if (l == 0) return true;

        // all * for ), valid enough or not
        int r = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == '*' || c == ')') r++;
            else if (r-- == 0) return false;
        }
        return true;
    }
}
