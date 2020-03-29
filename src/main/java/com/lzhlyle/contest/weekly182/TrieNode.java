package com.lzhlyle.contest.weekly182;

class TrieNode {
    private TrieNode[] links;
    private boolean isEnd;

    TrieNode() {
        links = new TrieNode[26];
    }

    void setChar(char c, TrieNode next) {
        links[c - 'a'] = next;
    }

    TrieNode getChar(char c) {
        return links[c - 'a'];
    }

    boolean contains(char c) {
        return links[c - 'a'] != null;
    }

    boolean isEnd() {
        return isEnd;
    }

    void setEnd() {
        isEnd = true;
    }
}
