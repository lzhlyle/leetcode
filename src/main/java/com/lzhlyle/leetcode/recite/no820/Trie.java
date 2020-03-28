package com.lzhlyle.leetcode.recite.no820;

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public boolean insert(String word) {
        TrieNode curr = root;
        // 倒插单词
        char[] arr = word.toCharArray();
        boolean isNew = false;
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
