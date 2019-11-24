package com.lzhlyle.leetcode.self.no208;

class TrieNode {
    private TrieNode[] links;
    private boolean isEnd;

    TrieNode() {
        links = new TrieNode[26];
    }

    public void set(char c, TrieNode next) {
        links[c - 'a'] = next;
    }

    public TrieNode get(char c) {
        return links[c - 'a'];
    }

    public boolean contains(char c) {
        return links[c - 'a'] != null;
    }

    public boolean isEnd() {
        return isEnd;
    }

    void setEnd() {
        isEnd = true;
    }
}
