package com.lzhlyle.leetcode.recite.no430;

import java.util.ArrayList;
import java.util.List;

public class FlattenAMultilevelDoublyLinkedList_DFS {
    public Node flatten(Node head) {
        if (head == null) return null;

        List<Node> list = new ArrayList<>();
        dfs(head, list);
        Node prev = new Node();
        for (Node curr : list) {
            // set points
            prev.next = curr;
            curr.prev = prev;
            // push
            prev = curr;
            // clear
            curr.child = null;
        }
        head.prev = null;
        return head;
    }

    private void dfs(Node curr, List<Node> list) {
        if (curr == null) return;
        list.add(curr);
        dfs(curr.child, list);
        dfs(curr.next, list);
    }
}
