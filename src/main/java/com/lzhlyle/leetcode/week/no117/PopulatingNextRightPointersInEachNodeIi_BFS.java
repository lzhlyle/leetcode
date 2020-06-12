package com.lzhlyle.leetcode.week.no117;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNodeIi_BFS {
    // bfs
    public Node connect(Node root) {
        if (root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Queue<Node> next = new LinkedList<>();
            while (!queue.isEmpty()) {
                Node node = queue.remove();
                if (!queue.isEmpty()) node.next = queue.element();
                if (node.left != null) next.add(node.left);
                if (node.right != null) next.add(node.right);
            }
            queue = next;
        }
        return root;
    }
}
