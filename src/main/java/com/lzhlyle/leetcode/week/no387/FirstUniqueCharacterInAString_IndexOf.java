package com.lzhlyle.leetcode.week.no387;

public class FirstUniqueCharacterInAString_IndexOf {
    public int firstUniqChar(String s) {
        if (s == null || s.length() < 1) return -1;
        int len;
        if ((len = s.length()) == 1) return 0;

        int res = len;
        for (char c = 'a'; c <= 'z'; c++) {
            int pos = s.indexOf(c);
            if (pos != -1 && s.lastIndexOf(c) == pos) res = Math.min(res, pos);
        }
        return res == len ? -1 : res;
    }
}
