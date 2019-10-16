package com.lzhlyle.leetcode.recite;

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

//leetcode submit region begin(Prohibit modification and deletion)
class LRUCache {

    private DoubleLinkedList list; // for sorting
    private HashMap<Integer, LRUCacheNode> map; // for looking up
    private int cacheCapacity;

    public LRUCache(int capacity) {
        list = new DoubleLinkedList();
        map = new HashMap<Integer, LRUCacheNode>();
        cacheCapacity = capacity;
    }

    public int get(int key) {
        // map: look up value
        LRUCacheNode node = _lookUpMap(key);
        if (node == null) {
            return -1;
        }

        // use once
        _usedOnce(node);

        // return value
        return node.value;
    }

    public void put(int key, int value) {
        LRUCacheNode node = _lookUpMap(key);
        if (node == null) {
            // new node
            node = new LRUCacheNode(key, value);
        } else {
            // update value
            node.value = value;
        }

        // use once
        _usedOnce(node);

        // then put in map
        map.put(key, node);
    }

    private LRUCacheNode _lookUpMap(int key) {
        return map.get(key);
    }

    private void _usedOnce(LRUCacheNode node) {
        // list: move to first
        list.makeNodeFirst(node);

        // ensure cache's capacity
        _ensureCapacity();
    }

    private void _ensureCapacity() {
        if (list.size > cacheCapacity) {
            // list: remove last
            LRUCacheNode last = list.removeLast();

            // remove from map
            map.remove(last.key);
        }
    }
}


// double linked list
class DoubleLinkedList {
    private LRUCacheNode head;
    private LRUCacheNode tail;
    int size;

    DoubleLinkedList() {
        // init virtual head and tail
        head = new LRUCacheNode(-1, 0);
        tail = new LRUCacheNode(-2, 0);

        // link them
        head.next = tail; // head.prev is null
        tail.prev = head; // tail.next is null

        size = 0;
    }

    LRUCacheNode removeLast() {
        LRUCacheNode target = tail.prev;
        if (target != head) {
            _removeNode(target);
        }
        return target;
    }

    void makeNodeFirst(LRUCacheNode node) {
        if (_contains(node)) {
            _removeNode(node);
        }
        _addNodeFirst(node);
    }

    private boolean _contains(LRUCacheNode node) {
        return node.prev != null;
    }

    private void _removeNode(LRUCacheNode target) {
        // current: p - TARGET - n

        // link node and tail
        target.next.prev = target.prev;
        target.prev.next = target.next;

        // dispose target's next and prev
        target.next = null;
        target.prev = null;

        size--;
    }

    private void _addNodeFirst(LRUCacheNode target) {
        // current: head - node

        // link node and target
        head.next.prev = target;
        target.next = head.next;

        // link head and target
        head.next = target;
        target.prev = head;

        size++;
    }
}

// lur cache node
class LRUCacheNode {
    int key;
    int value;
    LRUCacheNode prev;
    LRUCacheNode next;

    LRUCacheNode(int k, int v) {
        key = k;
        value = v;

        // single node
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

