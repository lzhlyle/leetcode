package com.lzhlyle.templates.structure;

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            if (!curr.contains(c)) curr.setChar(c, new TrieNode());
            curr = curr.getChar(c);
        }
        curr.setEnd();
    }

    public boolean search(String word) {
        TrieNode last = searchPrefix(word);
        return last != null && last.isEnd();
    }

    private TrieNode searchPrefix(String prefix) {
        TrieNode curr = root;
        for (char c : prefix.toCharArray()) {
            curr = curr.getChar(c);
            if (curr == null) return null;
        }
        return curr;
    }

    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
