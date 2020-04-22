package com.lzhlyle.leetcode.tomorrow.no460;

public class LFUCacheDbLinkedList {
    LFUCacheNode head, tail;

    public LFUCacheDbLinkedList() {
        head = new LFUCacheNode(-1, -1);
        tail = new LFUCacheNode(-2, -2);

        head.next = tail;
        tail.prev = head;
    }

    public void addFirst(LFUCacheNode target) {
        // head -> (target) -> node
        LFUCacheNode node = head.next;
        head.next = target;
        node.prev = target;

        target.prev = head;
        target.next = node;
    }

    public LFUCacheNode removeLast() {
        return remove(tail.prev);
    }

    public LFUCacheNode remove(LFUCacheNode target) {
        if (isEmpty()) return null;

        // node1 -> target -> node2
        LFUCacheNode node1 = target.prev, node2 = target.next;
        node1.next = node2;
        node2.prev = node1;

        target.prev = target.next = null;
        return target;
    }

    public boolean isEmpty() {
        return head.next == tail;
    }
}
