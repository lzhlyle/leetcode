package com.lzhlyle.leetcode.self.no14;

public class TrieNode {
    private TrieNode[] links;
    private boolean isEnd;

    public TrieNode() {
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

    int getLinks() {
        int res = 0;
        for (TrieNode link : links) if (link != null) res++;
        return res;
    }
}
