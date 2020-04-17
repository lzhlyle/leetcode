package com.lzhlyle.leetcode.week.no820;

public class TrieNode {
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

    public boolean isEnt() {
        return isEnd;
    }

    public void setEnd() {
        isEnd = true;
    }
}
