package com.lzhlyle.leetcode.recite.no5;

public class LongestPalindromicSubstring_BruteForce {
    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length(); j > i; j--) {
                String sub = s.substring(i, j);
                if (valid(sub) && sub.length() > res.length()) res = sub;
            }
        }
        return res;
    }

    private boolean valid(String str) {
        char[] arr = str.toCharArray();
        int left = 0, right = arr.length - 1;
        while (left < right) {
            if (arr[left++] != arr[right--]) return false;
        }
        return true;
    }
}
