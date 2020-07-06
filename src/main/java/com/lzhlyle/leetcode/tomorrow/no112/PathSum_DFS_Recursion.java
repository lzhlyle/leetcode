package com.lzhlyle.leetcode.tomorrow.no112;

public class PathSum_DFS_Recursion {
    public boolean hasPathSum(TreeNode root, int sum) {
        return dfs(root, 0, sum);
    }

    private boolean dfs(TreeNode node, int curr, int sum) {
        if (node == null) return false;
        if (node.left == null && node.right == null)
            return curr + node.val == sum;
        return dfs(node.left, curr + node.val, sum)
                || dfs(node.right, curr + node.val, sum);
    }
}
