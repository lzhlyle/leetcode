package com.lzhlyle.leetcode.week.no146ii;

public class CacheNode {
    int key, value;
    CacheNode prev, next;

    public CacheNode(int k, int v) {
        key = k;
        value = v;
        prev = next = null;
    }
}
