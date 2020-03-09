package com.lzhlyle.leetcode.recite.no543;

public class DiameterOfBinaryTree_Recursion {
    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return max;
    }

    private int depth(TreeNode node) {
        if (node == null) return 0;
        int l = depth(node.left), r = depth(node.right);
        max = Math.max(max, l + r);
        return Math.max(l, r) + 1;
    }
}
