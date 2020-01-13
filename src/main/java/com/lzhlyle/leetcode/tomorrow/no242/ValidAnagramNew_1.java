package com.lzhlyle.leetcode.tomorrow.no242;

import java.util.Arrays;

public class ValidAnagramNew_1 {
    // brute force: sort and compare
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;

        char[] sChars = s.toCharArray();
        Arrays.sort(sChars);
        char[] tChars = t.toCharArray();
        Arrays.sort(tChars);

        return Arrays.equals(sChars, tChars);
    }
}
