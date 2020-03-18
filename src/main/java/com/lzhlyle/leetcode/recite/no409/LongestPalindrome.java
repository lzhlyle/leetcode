package com.lzhlyle.leetcode.recite.no409;

public class LongestPalindrome {
    public int longestPalindrome(String s) {
        int[] freq = new int[64]; // 58 chars from A(65) to z(122)
        for (char c : s.toCharArray()) freq[c - 'A']++;
        int cnt = 0, odd = 0;
        for (int f : freq) {
            if (f == 0) continue;
            if (f == 1) odd++;
            else if (f % 2 == 0) cnt += f;
            else {
                odd++;
                cnt += f - 1;
            }
        }
        return cnt + (odd == 0 ? 0 : 1);
    }
}
