package com.lzhlyle.leetcode.week.no151;

public class ReverseWordsInAString_Split {
    public String reverseWords(String s) {
        String[] words = s.trim().split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = words.length - 1; i >= 1; i--) {
            String word = words[i];
            if (word.isEmpty()) continue;
            builder.append(word).append(' ');
        }
        builder.append(words[0]);
        return builder.toString();
    }
}
