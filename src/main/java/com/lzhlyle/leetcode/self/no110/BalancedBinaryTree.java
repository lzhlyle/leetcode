package com.lzhlyle.leetcode.self.no110;

public class BalancedBinaryTree {
    private boolean isBalanced = true;

    public boolean isBalanced(TreeNode root) {
        depth(root);
        return isBalanced;
    }

    private int depth(TreeNode curr) {
        if (curr == null || !isBalanced) return 0;
        int l = depth(curr.left), r = depth(curr.right);
        isBalanced = isBalanced && Math.abs(l - r) < 2;
        return Math.max(l, r) + 1;
    }
}
