package com.lzhlyle.templates.structure;

public class LFUCacheNode {
    int key, value, freq;
    LFUCacheNode prev, next;

    public LFUCacheNode(int key, int value) {
        this.key = key;
        this.value = value;
        this.freq = 1;
        this.prev = this.next = null;
    }
}
