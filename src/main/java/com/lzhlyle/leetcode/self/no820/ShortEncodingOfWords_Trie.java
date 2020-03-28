package com.lzhlyle.leetcode.self.no820;

import java.util.Arrays;
import java.util.Comparator;

public class ShortEncodingOfWords_Trie {
    // Trie
    public int minimumLengthEncoding(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        Trie trie = new Trie();
        int total = 0;
        for (int i = words.length - 1; i >= 0; i--) {
            total += trie.insert(words[i]) ? words[i].length() + 1 : 0;
        }
        return total;
    }
}
