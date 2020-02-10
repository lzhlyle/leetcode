package com.lzhlyle.leetcode.recite.no429;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NAryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) return Collections.emptyList();
        List<List<Integer>> res = new LinkedList<>();
        bfs(new LinkedList<>(Collections.singleton(root)), res);
        return res;
    }

    private void bfs(Queue<Node> queue, List<List<Integer>> res) {
        if (queue.isEmpty()) return;
        Queue<Node> next = new LinkedList<>();
        List<Integer> level = new LinkedList<>();
        while (!queue.isEmpty()) {
            Node node = queue.remove();
            if (node == null) continue;
            level.add(node.val);
            next.addAll(node.children);
        }
        res.add(level);
        bfs(next, res);
    }
}
