package com.lzhlyle.leetcode.self.no58;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int count = 0, i = s.length() - 1;
        while (i >= 0) {
            if (s.charAt(i--) != ' ') count++;
            else if (count > 0) return count;
        }
        return count;
    }
}
