package com.lzhlyle.leetcode.week.no146;

public class CacheDbLinkedList {
    private CacheNode head;
    private CacheNode tail;
    private int capacity;
    private int size;

    public CacheDbLinkedList(int capacity) {
        this.head = new CacheNode(-1, -1);
        this.tail = new CacheNode(-2, -2);

        this.head.next = this.tail;
        this.tail.prev = this.head;

        this.capacity = capacity;
        this.size = 0;
    }

    /**
     * add node
     *
     * @param target
     * @return removed node-
     */
    public CacheNode add(CacheNode target) {
        // head - (target) - node
        CacheNode node = head.next;

        target.prev = head;
        target.next = node;

        node.prev = target;
        head.next = target;

        this.size++;

        return _ensureCapacity();
    }

    public void first(CacheNode node) {
        this._remove(node);
        this.add(node);
    }

    private CacheNode _remove(CacheNode target) {
        // node1 - target - node2
        CacheNode node1 = target.prev;
        CacheNode node2 = target.next;

        node1.next = node2;
        node2.prev = node1;

        target.prev = null;
        target.next = null;

        this.size--;

        return target;
    }

    private CacheNode _ensureCapacity() {
        if (this.size > this.capacity) {
            // out of capacity
            return this._remove(tail.prev);
        }
        return null;
    }
}
