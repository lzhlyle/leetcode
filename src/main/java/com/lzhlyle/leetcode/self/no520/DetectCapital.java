package com.lzhlyle.leetcode.self.no520;

public class DetectCapital {
    public boolean detectCapitalUse(String word) {
        char[] arr = word.toCharArray();
        boolean first = cap(arr[0]), second = false;
        for (int i = 1; i < arr.length; i++) {
            boolean cap = cap(arr[i]);
            if (i == 1) {
                if (!first && cap) return false;
                second = cap;
            } else if (second != cap) return false;
        }
        return true;
    }

    private boolean cap(char c) {
        return c >= 'A' && c <= 'Z';
    }
}
