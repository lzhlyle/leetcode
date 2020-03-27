package com.lzhlyle.templates.structure;

import java.util.HashMap;
import java.util.Map;

/**
 * LRU 缓存
 */
public class LruCache {

    private Map<Integer, LruCacheNode> map;
    private LruCacheDbLinkedList list;

    public LruCache(int capacity) {
        map = new HashMap<>();
        list = new LruCacheDbLinkedList(capacity);
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        LruCacheNode res = map.get(key);
        _useOnce(res);
        return res.value;
    }

    public void put(int key, int value) {
        if (!map.containsKey(key)) {
            // new node
            LruCacheNode node = new LruCacheNode(key, value);
            map.put(key, node);
            _useOnce(node);
        } else {
            // existed
            LruCacheNode node = map.get(key);
            node.value = value;
            _useOnce(node);
        }
    }

    private void _useOnce(LruCacheNode node) {
        if (node.next == null) {
            // new node
            LruCacheNode removed = list.add(node);
            if (removed != null) map.remove(removed.key);
        } else {
            // existed
            list.moveToFirst(node);
        }
    }
}
