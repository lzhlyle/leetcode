package com.lzhlyle.leetcode.week.no687;

public class LongestUnivaluePath_LC {
    private int max;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        max = 0;
        dfs(root, root.val);
        return max;
    }

    private int dfs(TreeNode node, int last) {
        if (node == null) return 0;
        int l = dfs(node.left, node.val), r = dfs(node.right, node.val);
        max = Math.max(max, l + r);
        if (node.val == last) return Math.max(l, r) + 1;
        return 0;
    }
}
