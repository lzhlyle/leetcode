package com.lzhlyle.leetcode.recite.no199;

import java.util.*;

public class BinaryTreeRightSideView_BFS_Recursive {
    // bfs
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return Collections.emptyList();
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        bfs(queue, res);
        return res;
    }

    private void bfs(Deque<TreeNode> queue, List<Integer> res) {
        if (queue.isEmpty()) return;
        res.add(queue.getLast().val);
        Deque<TreeNode> next = new LinkedList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if (node.left != null) next.add(node.left);
            if (node.right != null) next.add(node.right);
        }
        bfs(next, res);
    }
}
