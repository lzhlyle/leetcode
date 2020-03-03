package com.lzhlyle.leetcode.self.no151;

public class ReverseWordsInAString_Split {
    public String reverseWords(String s) {
        s = s.trim();
        String[] words = s.split(" +");
        StringBuilder builder = new StringBuilder();
        for (int i = words.length - 1; i > 0; i--) {
            builder.append(words[i]).append(" ");
        }
        builder.append(words[0]);
        return builder.toString();
    }
}
