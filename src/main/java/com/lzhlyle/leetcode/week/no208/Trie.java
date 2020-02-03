package com.lzhlyle.leetcode.week.no208;

public class Trie {
    private TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        char[] arr = word.toCharArray();
        TrieNode curr = root;
        for (char c : arr) {
            if (!curr.contains(c)) curr.set(c, new TrieNode());
            curr = curr.get(c);
        }
        curr.setEnd();
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode last = _searchPrefix(word);
        return last != null && last.isEnd();
    }

    private TrieNode _searchPrefix(String prefix) {
        TrieNode curr = root;
        char[] arr = prefix.toCharArray();
        for (char c : arr) {
            if (curr.contains(c)) curr = curr.get(c);
            else return null;
        }
        return curr;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        return _searchPrefix(prefix) != null;
    }
}
