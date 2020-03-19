package com.lzhlyle.leetcode.week.no543;

public class DiameterOfBinaryTree_Recursion {
    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return max;
    }

    private int depth(TreeNode root) {
        if (root == null) return 0;
        int l = depth(root.left), r = depth(root.right);
        max = Math.max(max, l + r);
        return Math.max(l, r) + 1;
    }
}
