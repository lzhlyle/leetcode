package com.lzhlyle.templates.structure;

public class LruCacheNode {

    int key, value;
    LruCacheNode prev, next;

    public LruCacheNode(int key, int value) {
        this.key = key;
        this.value = value;
        this.prev = this.next = null;
    }
}
