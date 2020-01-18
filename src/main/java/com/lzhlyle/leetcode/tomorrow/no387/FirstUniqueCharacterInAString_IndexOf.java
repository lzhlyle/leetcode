package com.lzhlyle.leetcode.tomorrow.no387;

public class FirstUniqueCharacterInAString_IndexOf {
    public int firstUniqChar(String s) {
        if (s == null || s.length() < 1) return -1;
        int res = s.length();
        for (char c = 'a'; c < 'z'; c++) {
            int pos = s.indexOf(c);
            if (pos != -1 && pos == s.lastIndexOf(c)) res = Math.min(res, pos);
        }
        return res == s.length() ? -1 : res;
    }
}
