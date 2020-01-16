package com.lzhlyle.leetcode.tomorrow.no208;

class TrieNode {
    private TrieNode[] links;
    private boolean isEnd;

    public TrieNode() {
        links = new TrieNode[26];
        isEnd = false;
    }

    public TrieNode get(char c) {
        return links[c - 'a'];
    }

    public void set(char c, TrieNode next) {
        links[c - 'a'] = next;
    }

    public boolean contains(char c) {
        return links[c - 'a'] != null;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd() {
        isEnd = true;
    }
}
