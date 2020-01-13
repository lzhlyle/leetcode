package com.lzhlyle.leetcode.tomorrow.no242;

public class ValidAnagramNew_3 {
    // hash map
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;

        int[] arr = new int[26];
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        for (int i = 0; i < sChar.length; i++) {
            arr[sChar[i] - 'a']++;
            arr[tChar[i] - 'a']--;
        }
        for (int v : arr) if (v != 0) return false;
        return true;
    }
}
