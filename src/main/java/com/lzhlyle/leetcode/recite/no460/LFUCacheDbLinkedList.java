package com.lzhlyle.leetcode.recite.no460;

public class LFUCacheDbLinkedList {
    private LFUCacheNode head, tail;

    public LFUCacheDbLinkedList() {
        head = new LFUCacheNode(-1, -1);
        tail = new LFUCacheNode(-2, -2);
        head.next = tail;
        tail.prev = head;
    }

    public void add(LFUCacheNode target) {
        // head - (target) - node
        LFUCacheNode node = head.next;
        target.prev = head;
        target.next = node;

        head.next = target;
        node.prev = target;
    }

    public LFUCacheNode removeLast() {
        if (tail.prev == head) throw new RuntimeException("empty list");
        return remove(tail.prev);
    }

    public LFUCacheNode remove(LFUCacheNode target) {
        // node1 - target - node2
        LFUCacheNode node1 = target.prev, node2 = target.next;

        node1.next = node2;
        node2.prev = node1;

        target.prev = target.next = null;
        return target;
    }

    public boolean isEmpty() {
        return head.next == tail;
    }

//    @Override
//    public String toString() {
//        StringBuilder builder = new StringBuilder();
//        LFUCacheNode curr = head.next;
//        while (curr != tail) {
//            builder.append(curr.key).append(" -> ");
//            curr = curr.next;
//        }
//        return "List{" + builder.toString() + "}";
//    }
}
