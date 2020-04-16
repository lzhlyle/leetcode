package com.lzhlyle.leetcode.recite.no678;

public class ValidParenthesisString_LC_ForTwice {
    public boolean checkValidString(String s) {
        // all * for (, valid enough or not
        int bal = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '*') bal++;
            else if (bal-- == 0) return false;
        }
        if (bal == 0) return true;

        // all * for ), valid enough or not
        bal = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == '*' || c == ')') bal++;
            else if (bal-- == 0) return false;
        }
        return true;
    }
}
