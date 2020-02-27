package com.lzhlyle.leetcode.recite.no58;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int res = 0, i = s.length() - 1;
        while (i >= 0) {
            if (s.charAt(i--) != ' ') res++;
            else if (res > 0) return res;
        }
        return res;
    }
}
