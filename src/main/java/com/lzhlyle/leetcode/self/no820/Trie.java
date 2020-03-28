package com.lzhlyle.leetcode.self.no820;

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public boolean insert(String word) {
        boolean isNew = false;
        TrieNode curr = root;
        char[] arr = word.toCharArray();
        for (int i = arr.length - 1; i >= 0; i--) {
            char c = arr[i];
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
