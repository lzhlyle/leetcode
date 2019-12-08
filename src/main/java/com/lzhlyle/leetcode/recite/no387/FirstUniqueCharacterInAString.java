package com.lzhlyle.leetcode.recite.no387;

public class FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        // base condition
        if (s == null || s.length() < 1) return -1;

        int res = s.length();
        for (char c = 'a'; c <= 'z'; c++) {
            int index = s.indexOf(c);
            if (index != -1 && index == s.lastIndexOf(c)) res = Math.min(res, index);
        }

        return res == s.length() ? -1 : res;
    }
}
