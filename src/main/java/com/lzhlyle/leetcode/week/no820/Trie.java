package com.lzhlyle.leetcode.week.no820;

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public boolean insert(String word) {
        boolean isNew = false;
        char[] chars = word.toCharArray();
        TrieNode curr = root;
        for (int i = chars.length - 1; i >= 0; i--) {
            char c = chars[i];
            if (!curr.contains(c)) {
                curr.set(c, new TrieNode());
                isNew = true;
            }
            curr = curr.get(c);
        }
        curr.setEnd();
        return isNew;
    }
}
