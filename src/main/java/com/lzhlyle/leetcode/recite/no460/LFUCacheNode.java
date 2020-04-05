package com.lzhlyle.leetcode.recite.no460;

public class LFUCacheNode {
    int key, value, freq;
    LFUCacheNode prev, next;

    public LFUCacheNode(int key, int value) {
        this.key = key;
        this.value = value;
        this.freq = 1;
        this.prev = this.next = null;
    }

//    @Override
//    public String toString() {
//        return "Node{" +
//                "key=" + key +
//                ", value=" + value +
//                ", freq=" + freq +
//                '}';
//    }
}
