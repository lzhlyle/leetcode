package com.lzhlyle.leetcode.week.no430;

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

        Node res = tail(curr.next, tail(curr.child, curr));
        curr.child = null;
        return res;
    }
}
