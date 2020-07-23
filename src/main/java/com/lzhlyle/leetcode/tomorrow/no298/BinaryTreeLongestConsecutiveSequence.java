package com.lzhlyle.leetcode.tomorrow.no298;

public class BinaryTreeLongestConsecutiveSequence {
    private int max;

    public int longestConsecutive(TreeNode root) {
        if (root == null) return 0;
        max = 1;
        dfs(root);
        return max;
    }

    // 从此往下有多长可顺
    private int dfs(TreeNode node) {
        if (node == null) return 0;
        int l = dfs(node.left), r = dfs(node.right);
        if (l == 0 && r == 0) return 1;
        if (l > 0 && node.left.val != node.val + 1) l = 0;
        if (r > 0 && node.right.val != node.val + 1) r = 0;

        int res = Math.max(l, r) + 1;
        max = Math.max(max, res);
        return res;
    }
}
