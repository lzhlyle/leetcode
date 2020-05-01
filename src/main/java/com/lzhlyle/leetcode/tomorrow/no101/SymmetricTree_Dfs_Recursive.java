package com.lzhlyle.leetcode.self.no101;

public class SymmetricTree_Dfs_Recursive {
    // dfs recursive
    public boolean isSymmetric(TreeNode root) {
        return dfs(root, root);
    }

    private boolean dfs(TreeNode l, TreeNode r) {
        if (l == null && r == null) return true;
        if (l == null || r == null) return false;
        if (l.val != r.val) return false;
        return dfs(l.left, r.right) && dfs(l.right, r.left);
    }
}
