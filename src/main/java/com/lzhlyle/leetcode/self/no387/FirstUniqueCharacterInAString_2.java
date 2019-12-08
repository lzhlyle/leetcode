package com.lzhlyle.leetcode.self.no387;

public class FirstUniqueCharacterInAString_2 {
    public int firstUniqChar(String s) {
        // base condition
        if (s == null || s.length() < 1) return -1;

        int res = s.length();
        for (char c = 'a'; c <= 'z'; c++) {
            int index = s.indexOf(c);
            if (index != -1 && s.indexOf(c) == s.lastIndexOf(c)) res = Math.min(res, index);
        }
        return res == s.length() ? -1 : res;
    }
}
