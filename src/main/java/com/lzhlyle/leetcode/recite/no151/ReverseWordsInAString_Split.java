package com.lzhlyle.leetcode.recite.no151;

public class ReverseWordsInAString_Split {
    public String reverseWords(String s) {
        s = s.trim();
        String[] words = s.split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            String word = words[i];
            if (word.isEmpty()) continue;
            builder.append(word);
            if (i > 0) builder.append(" ");
        }
        return builder.toString();
    }
}
