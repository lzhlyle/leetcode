package com.lzhlyle.leetcode.tomorrow.no101;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree_Bfs_Iteration {
    // bfs iterate
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);
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
