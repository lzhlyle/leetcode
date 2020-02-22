package com.lzhlyle.leetcode.recite.no10;

public class RegularExpressionMatching_Recursion {
    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) return s.isEmpty();
        boolean first = !s.isEmpty() && (p.charAt(0) == '.' || (s.charAt(0) == p.charAt(0)));
        if (p.length() > 1 && p.charAt(1) == '*') { // 提前找星号
            return isMatch(s, p.substring(2)) // 0次
                    || (first && isMatch(s.substring(1), p)); // 多次
        }
        return first && isMatch(s.substring(1), p.substring(1));
    }
}
