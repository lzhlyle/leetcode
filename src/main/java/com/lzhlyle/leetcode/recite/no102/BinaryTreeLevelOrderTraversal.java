package com.lzhlyle.leetcode.recite.no102;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return Collections.emptyList();
        List<List<Integer>> res = new LinkedList<>();
        bfs(new LinkedList<>(Collections.singleton(root)), res);
        return res;
    }

    private void bfs(Queue<TreeNode> queue, List<List<Integer>> res) {
        if (queue.isEmpty()) return;
        List<Integer> level = new LinkedList<>();
        Queue<TreeNode> nextQueue = new LinkedList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            level.add(node.val);
            if (node.left != null) nextQueue.add(node.left);
            if (node.right != null) nextQueue.add(node.right);
        }
        res.add(level);
        bfs(nextQueue, res);
    }
}
