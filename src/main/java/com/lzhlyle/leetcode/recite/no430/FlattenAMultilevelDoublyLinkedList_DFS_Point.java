package com.lzhlyle.leetcode.recite.no430;

public class FlattenAMultilevelDoublyLinkedList_DFS_Point {
    public Node flatten(Node head) {
        if (head == null) return null;
        tail(head, new Node());
        head.prev = null;
        return head;
    }

    public Node tail(Node curr, Node prev) {
        if (curr == null) return prev;
        curr.prev = prev;
        prev.next = curr;

        Node oriNext = curr.next;
        Node tail = tail(curr.child, curr);
        curr.child = null;
        return tail(oriNext, tail);
    }
}
