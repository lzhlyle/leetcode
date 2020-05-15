package com.lzhlyle.leetcode.week.no101;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree_Bfs_Iteration {
    // bfs iterate
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);
        while (!queue.isEmpty()) {
            TreeNode l = queue.remove();
            TreeNode r = queue.remove();
            if (l == null && r == null) continue;
            if (l == null || r == null) return false;
            if (l.val != r.val) return false;
            queue.addAll(Arrays.asList(l.left, r.right, l.right, r.left));
        }
        return true;
    }
}
