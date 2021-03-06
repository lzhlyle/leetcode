package com.lzhlyle.leetcode.tomorrow.no146;

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
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class LRUCache {
    private CacheLinkedList list;
    private Map<Integer, CacheNode> map;
    int maxCapacity;

    public LRUCache(int capacity) {
        list = new CacheLinkedList();
        map = new HashMap<>();
        maxCapacity = capacity;
    }

    public int get(int key) {
        CacheNode node = map.get(key);
        if (node != null) {
            _useOnce(node);
            return node.value;
        }

        return -1;
    }

    public void put(int key, int value) {
        CacheNode node = map.get(key);
        if (node != null) {
            node.value = value;
            _useOnce(node);
        } else {
            CacheNode newNode = new CacheNode(key, value);
            list.addFirst(newNode);

            map.put(key, newNode);

            if (list.size > maxCapacity) {
                CacheNode removedOne = list.removeLast();
                if (removedOne != null) {
                    map.remove(removedOne.key);
                }
            }
        }
    }

    private void _useOnce(CacheNode node) {
        list.remove(node);
        list.addFirst(node);
    }
}

class CacheLinkedList {
    private CacheNode head;
    private CacheNode tail;
    int size;

    CacheLinkedList() {
        head = new CacheNode(-1, -1);
        tail = new CacheNode(-2, -2);

        head.next = tail;
        tail.prev = head;

        size = 0;
    }

    CacheNode removeLast() {
        if (size > 0) {
            CacheNode last = tail.prev;
            remove(last);
            return last;
        }
        return null;
    }

    void addFirst(CacheNode target) {
        // head - node

        // for: TARGET - node
        head.next.prev = target;
        target.next = head.next;

        // for: head - TARGET
        head.next = target;
        target.prev = head;

        size++;
    }

    void remove(CacheNode target) {
        // node1 - TARGET - node2

        target.next.prev = target.prev;
        target.prev.next = target.next;

        target.next = null;
        target.prev = null;

        size--;
    }
}

class CacheNode {
    int key;
    int value;
    CacheNode prev;
    CacheNode next;

    CacheNode(int k, int v) {
        key = k;
        value = v;

        prev = null;
        next = null;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)
