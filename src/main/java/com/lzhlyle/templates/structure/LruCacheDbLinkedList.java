package com.lzhlyle.templates.structure;

public class LruCacheDbLinkedList {
    private int capacity, size;
    private LruCacheNode head, tail;

    public LruCacheDbLinkedList(int capacity) {
        this.capacity = capacity;
        this.size = 0;

        head = new LruCacheNode(-1, -1);
        tail = new LruCacheNode(-2, -2);
        head.next = tail;
        tail.prev = head;
    }

    /**
     * add node and return removed node
     *
     * @param target
     * @return removed node
     */
    public LruCacheNode add(LruCacheNode target) {
        // head - (target) - node
        LruCacheNode node = head.next;
        target.prev = head;
        target.next = node;

        head.next = target;
        node.prev = target;

        size++;
        return _ensureCapacity();
    }

    public void moveToFirst(LruCacheNode node) {
        _remove(node);
        add(node);
    }

    private LruCacheNode _remove(LruCacheNode target) {
        // node1 - target - node2
        LruCacheNode node1 = target.prev, node2 = target.next;

        node1.next = node2;
        node2.prev = node1;

        size--;

        target.prev = target.next = null;
        return target;
    }

    private LruCacheNode _ensureCapacity() {
        if (size > capacity) return _remove(tail.prev);
        return null;
    }
}
