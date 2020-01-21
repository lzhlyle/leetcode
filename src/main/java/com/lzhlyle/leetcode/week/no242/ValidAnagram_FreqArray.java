package com.lzhlyle.leetcode.week.no242;

public class ValidAnagram_FreqArray {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;

        int[] freq = new int[26];
        char[] arrS = s.toCharArray();
        char[] arrT = t.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            freq[arrS[i] - 'a']++;
            freq[arrT[i] - 'a']--;
        }

        for (int f : freq) {
            if (f != 0) return false;
        }
        return true;
    }
}
