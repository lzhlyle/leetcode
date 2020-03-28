package com.lzhlyle.leetcode.recite.no820;

import java.util.Arrays;
import java.util.Comparator;

public class ShortEncodingOfWords_Naive_StringBuilder {
    // wrong?
    // naive
    public int minimumLengthEncoding(String[] words) {
        // sort by length asc
        Arrays.sort(words, Comparator.comparingInt(String::length));

        // interval words from max-length
        // add into set if index of any words in set.
        StringBuilder str = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            String word = words[i];
            if (str.toString().contains(word)) continue;
            str.append(word).append('#');
        }
        return str.length();
    }
}
