package com.lzhlyle.leetcode.self.no520;

public class DetectCapital_LC {
    public boolean detectCapitalUse(String word) {
        int cnt = 0;
        for (char c : word.toCharArray()) if (c <= 'Z') cnt++;
        return cnt == 0 || cnt == word.length() || (cnt == 1 && word.charAt(0) <= 'Z');
    }
}
