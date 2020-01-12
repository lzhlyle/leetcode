package com.lzhlyle.leetcode.week.no146ii;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private Map<Integer, CacheNode> map;
    private CacheDbLinkedList list;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        list = new CacheDbLinkedList(capacity);
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        CacheNode node = map.get(key);
        _useOnce(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (!map.containsKey(key)) {
            CacheNode newNode = new CacheNode(key, value);
            _useOnce(newNode);
            map.put(key, newNode);
            return;
        }
        CacheNode node = map.get(key);
        node.value = value;
        _useOnce(node);
    }

    private void _useOnce(CacheNode target) {
        if (target.next == null) {
            CacheNode removed = list.add(target);
            if (removed != null) map.remove(removed.key);
            return;
        }
        list.first(target);
    }
}
