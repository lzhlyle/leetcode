package com.lzhlyle.leetcode.week.no146;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private CacheDbLinkedList list;
    private Map<Integer, CacheNode> map;

    public LRUCache(int capacity) {
        list = new CacheDbLinkedList(capacity);
        map = new HashMap<>();
    }

    public int get(int key) {
        CacheNode node = map.get(key);
        if (node == null) {
            return -1; // not find
        }

        this._useOnce(node);

        return node.val;
    }

    public void put(int key, int value) {
        CacheNode node = map.get(key);
        if (node == null) {
            // not exist
            node = new CacheNode(key, value);
            this._useOnce(node);
            map.put(key, node);
        } else {
            // exist
            node.val = value;
            this._useOnce(node);
        }
    }

    private void _useOnce(CacheNode node) {
        if (node.next == null) {
            // new node, insert into list
            CacheNode removed = list.add(node);
            if (removed != null) {
                map.remove(removed.key);
            }
        } else {
            // existed node, move it after head
            list.first(node);
        }
    }
}
