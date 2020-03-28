package com.lzhlyle.leetcode.recite.no820;

public class TrieNode {
    private TrieNode[] links;
    private boolean isEnd;

    public TrieNode() {
        this.links = new TrieNode[26];
        this.isEnd = false;
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

    public void setEnd() {
        isEnd = true;
    }
}
