package com.lzhlyle.leetcode.week.no146;

public class CacheNode {
    int key;
    int val;
    CacheNode prev;
    CacheNode next;

    public CacheNode(int k, int v) {
        key = k;
        val = v;
        prev = null;
        next = null;
    }
}
