package com.lzhlyle.leetcode.self;

//运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
//
// 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
//写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
//
// 进阶:
//
// 你是否可以在 O(1) 时间复杂度内完成这两种操作？
//
// 示例:
//
// LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );
//
//cache.put(1, 1);
//cache.put(2, 2);
//cache.get(1);       // 返回  1
//cache.put(3, 3);    // 该操作会使得密钥 2 作废
//cache.get(2);       // 返回 -1 (未找到)
//cache.put(4, 4);    // 该操作会使得密钥 1 作废
//cache.get(1);       // 返回 -1 (未找到)
//cache.get(3);       // 返回  3
//cache.get(4);       // 返回  4
//
// Related Topics 设计


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class LRUCache {
    private List<LRUCacheNode> list;
    private Map<Integer, LRUCacheNode> map;
    private int maxSize;

    public LRUCache(int capacity) {
        list = new LinkedList<>();
        map = new HashMap<>();
        maxSize = capacity;
    }

    public int get(int key) {
        LRUCacheNode node = map.get(key);
        if (node != null) {
            _useOnce(node);
            return node.value;
        }

        return -1;
    }

    public void put(int key, int value) {
        LRUCacheNode node = map.get(key);
        if (node != null) {
            // update
            node.value = value;
            _useOnce(node);

            map.put(key, node);
        } else {
            LRUCacheNode newNode = new LRUCacheNode(key, value);
            list.add(0, newNode);

            map.put(key, newNode);

            _ensureCapacity();
        }
    }

    private void _useOnce(LRUCacheNode node) {
        list.remove(node);
        list.add(0, node);
    }

    private void _ensureCapacity() {
        if (list.size() > maxSize) {
            LRUCacheNode removedOne = list.remove(list.size() - 1);

            map.remove(removedOne.key);
        }
    }
}

class LRUCacheNode {
    int key;
    int value;

    LRUCacheNode(int k, int v) {
        key = k;
        value = v;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)
