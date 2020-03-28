package com.lzhlyle.leetcode.recite.no820;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class ShortEncodingOfWords_Naive_Set {
    // wrong?
    // naive
    public int minimumLengthEncoding(String[] words) {
        // sort by length asc
        Arrays.sort(words, Comparator.comparingInt(String::length));

        // interval words from max-length
        // add into set if index of any words in set.
        int res = 0;
        Set<String> set = new HashSet<>();
        for (int i = words.length - 1; i >= 0; i--) {
            String word = words[i];
            boolean include = false;
            for (String existed : set) {
                if (existed.contains(word)) {
                    include = true;
                    break;
                }
            }
            if (include) continue;
            set.add(word);
            res += word.length() + 1;
        }
        return res;
    }
}
