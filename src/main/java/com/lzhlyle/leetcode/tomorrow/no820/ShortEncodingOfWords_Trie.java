package com.lzhlyle.leetcode.tomorrow.no820;

import java.util.Arrays;
import java.util.Comparator;

public class ShortEncodingOfWords_Trie {
    // Trie
    public int minimumLengthEncoding(String[] words) {
        int total = 0;
        Arrays.sort(words, Comparator.comparingInt(String::length));
        Trie trie = new Trie();
        for (int i = words.length - 1; i >= 0; i--) {
            if (trie.insert(words[i])) total += words[i].length() + 1;
        }
        return total;
    }
}
