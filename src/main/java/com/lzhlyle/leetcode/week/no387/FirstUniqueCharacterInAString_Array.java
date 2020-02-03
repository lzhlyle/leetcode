package com.lzhlyle.leetcode.week.no387;

public class FirstUniqueCharacterInAString_Array {
    public int firstUniqChar(String s) {
        if (s == null || s.length() < 1) return -1;
        int len = s.length();
        if (len == 1) return 0;
        
        int[] freq = new int[26];
        char[] arr = s.toCharArray();
        for (char c : arr) freq[c - 'a']++;
        for (int i = 0; i < len; i++) if (freq[arr[i] - 'a'] == 1) return i;
        return -1;
    }
}
