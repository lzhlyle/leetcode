package com.lzhlyle.leetcode.tomorrow.no460;

public class LFUCacheNode {
    int key, value, freq;
    LFUCacheNode prev, next;

    public LFUCacheNode(int key, int value) {
        this.key = key;
        this.value = value;
        freq = 1;
        prev = next = null;
    }
}
