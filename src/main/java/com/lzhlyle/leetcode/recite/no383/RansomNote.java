package com.lzhlyle.leetcode.recite.no383;

public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;
        int[] freq = new int[26];
        for (char c : magazine.toCharArray()) freq[c - 'a']++;
        for (char c : ransomNote.toCharArray()) {
            if (freq[c - 'a']-- == 0) return false;
        }
        return true;
    }
}
