package com.lzhlyle.leetcode.recite.no543;

public class DiameterOfBinaryTree_DP {
    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        depth(root);
        return max;
    }

    private int[] depth(TreeNode node) {
        int[] dp = new int[2]; // 0:left, 1:right
        if (node.left != null) {
            int[] dpl = depth(node.left);
            dp[0] = Math.max(dpl[0], dpl[1]) + 1;
        }
        if (node.right != null) {
            int[] dpr = depth(node.right);
            dp[1] = Math.max(dpr[0], dpr[1]) + 1;
        }
        max = Math.max(max, dp[0] + dp[1]);
        return dp;
    }
}
