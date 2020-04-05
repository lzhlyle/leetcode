package com.lzhlyle.leetcode.self.no460;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {
    private Map<Integer, LFUCacheNode> map;
    private Map<Integer, LFUCacheDbLinkedList> freqMap;
    private int capacity, size, minF;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        size = 0;
        minF = 1;
        map = new HashMap<>();
        freqMap = new HashMap<>();
        freqMap.put(1, new LFUCacheDbLinkedList());
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;

        LFUCacheNode node = map.get(key);
        useOnce(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            // exist
            LFUCacheNode node = map.get(key);
            node.value = value;
            useOnce(node);
            return;
        }

        // not exist
        LFUCacheNode newOne = new LFUCacheNode(key, value);
        map.put(key, newOne);
        LFUCacheDbLinkedList list1 = freqMap.get(1);
        list1.addFirst(newOne);
        if (size == capacity) {
            LFUCacheDbLinkedList minFList = freqMap.get(minF);
            LFUCacheNode removed = minFList.removeLast();
            if (removed != null) map.remove(removed.key);
        } else size++;
        minF = 1;
    }

    private void useOnce(LFUCacheNode node) {
        LFUCacheDbLinkedList oriList = freqMap.get(node.freq);
        oriList.remove(node);

        int newF = node.freq + 1;
        if (!freqMap.containsKey(newF)) freqMap.put(newF, new LFUCacheDbLinkedList());
        freqMap.get(newF).addFirst(node);

        if (minF == node.freq && oriList.isEmpty()) minF = newF;

        node.freq = newF;
    }
}
