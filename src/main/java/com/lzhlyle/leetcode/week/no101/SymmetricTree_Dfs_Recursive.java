package com.lzhlyle.leetcode.week.no101;

public class SymmetricTree_Dfs_Recursive {
    // dfs recursive
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return valid(root.left, root.right);
    }

    private boolean valid(TreeNode l, TreeNode r) {
        if (l == null && r == null) return true;
        if (l == null || r == null) return false;
        if (l.val != r.val) return false;
        return valid(l.left, r.right) && valid(l.right, r.left);
    }
}
