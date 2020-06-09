package com.lzhlyle.leetcode.week.no124;

public class BinaryTreeMaximumPathSum_DFS {
    private int max;

    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        dfs(root);
        return max;
    }

    private int dfs(TreeNode curr) {
        if (curr == null) return 0;
        int l = Math.max(0, dfs(curr.left)), r = Math.max(0, dfs(curr.right));
        max = Math.max(max, curr.val + l + r); // 以 curr 为顶点时
        return curr.val + Math.max(l, r); // 以 curr 之上为顶点，则只能 l / r
    }
}
