package com.lzhlyle.leetcode.self.no687;

public class LongestUnivaluePath {
    private int max;

    public int longestUnivaluePath(TreeNode root) {
        max = 0;
        dfs(root);
        return max;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;
        int l = dfs(node.left), r = dfs(node.right);
        int total = 1;
        if (l > 0 && node.val == node.left.val) total += l;
        else l = 0; // 不同，清空
        if (r > 0 && node.val == node.right.val) total += r;
        else r = 0; // 不同，清空
        max = Math.max(max, total - 1);
        return 1 + Math.max(l, r);
    }
}
