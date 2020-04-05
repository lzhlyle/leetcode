package com.lzhlyle.leetcode.recite.no460;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {
    private Map<Integer, LFUCacheNode> map;
    private Map<Integer, LFUCacheDbLinkedList> freqMap;
    private int size, capacity, minF;

    public LFUCache(int capacity) {
        map = new HashMap<>();
        freqMap = new HashMap<>();
        freqMap.put(1, new LFUCacheDbLinkedList());
        this.capacity = capacity;
        size = 0;
        minF = 1;
    }

    public int get(int key) {
        int res = -1;
        if (map.containsKey(key)) {
            LFUCacheNode node = map.get(key);
            res = node.value;
            useOnce(node);
        }
//        System.out.println(res);
        return res;
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
        list1.add(newOne);
        if (size == capacity) {
            LFUCacheDbLinkedList listMin = freqMap.get(minF);
            LFUCacheNode removed = listMin.removeLast();
            map.remove(removed.key);
        } else size++;
        minF = 1;
    }

    private void useOnce(LFUCacheNode node) {
        LFUCacheDbLinkedList oriList = freqMap.get(node.freq);
        oriList.remove(node);

        int newF = node.freq + 1;
        if (minF == node.freq && oriList.isEmpty()) minF = newF;

        if (!freqMap.containsKey(newF)) freqMap.put(newF, new LFUCacheDbLinkedList());
        LFUCacheDbLinkedList newList = freqMap.get(newF);
        newList.add(node);

        node.freq = newF;
    }
}
