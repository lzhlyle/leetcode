package com.lzhlyle.leetcode.week.no146ii;

public class CacheDbLinkedList {
    private CacheNode head, tail;
    private int capacity, size;

    public CacheDbLinkedList(int capacity) {
        this.capacity = capacity;
        size = 0;

        head = new CacheNode(-1, -1);
        tail = new CacheNode(-2, -2);
        head.next = tail;
        tail.prev = head;
    }

    public CacheNode add(CacheNode target) {
        CacheNode n = head.next;

        target.prev = head;
        target.next = n;

        n.prev = head.next = target;

        size++;

        return _ensureCapacity();
    }

    public void first(CacheNode target) {
        _remove(target);
        add(target);
    }

    private CacheNode _ensureCapacity() {
        return capacity < size ? _remove(tail.prev) : null;
    }

    private CacheNode _remove(CacheNode target) {
        CacheNode n1 = target.prev;
        CacheNode n2 = target.next;

        n1.next = n2;
        n2.prev = n1;

        target.prev = target.next = null;

        size--;

        return target;
    }
}
