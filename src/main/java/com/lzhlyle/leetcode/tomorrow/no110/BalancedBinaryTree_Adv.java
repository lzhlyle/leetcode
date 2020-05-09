package com.lzhlyle.leetcode.tomorrow.no110;

public class BalancedBinaryTree_Adv {
    public boolean isBalanced(TreeNode root) {
        int d = depth(root);
        return d != -1;
    }

    private int depth(TreeNode curr) {
        if (curr == null) return 0;
        int l = depth(curr.left);
        if (l == -1) return -1;

        int r = depth(curr.right);
        if (r == -1) return -1;

        if (Math.abs(l - r) > 1) return -1;
        return Math.max(l, r) + 1;
    }
}
