package com.lzhlyle.leetcode.tomorrow.no387;

public class FirstUniqueCharacterInAString_Array {
    public int firstUniqChar(String s) {
        if (s == null || s.length() < 1) return -1;
        if (s.length() == 1) return 0;

        int[] freq = new int[26];

        char[] chars = s.toCharArray();
        for (char c : chars) freq[c - 'a']++;
        for (int i = 0; i < chars.length; i++) {
            if (freq[chars[i] - 'a'] == 1) return i;
        }
        return -1;
    }
}
