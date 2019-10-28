package com.lzhlyle.leetcode.tomorrow.no242;

public class ValidAnagram_3 {
    public boolean isAnagram(String s, String t) {
        // base condition
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;

        // ASCII数组，简化哈希表
        int[] arr = new int['z' - 'a' + 1];
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            arr[sChar - 'a']++;

            char tChar = t.charAt(i);
            arr[tChar - 'a']--;
        }

        for (int times : arr) {
            if (times != 0) return false;
        }

        return true;
    }
}
