package com.lzhlyle.leetcode.self.no538;

public class ConvertBstToGreaterTree {
    private int curr;

    public TreeNode convertBST(TreeNode root) {
        curr = 0;
        dfs(root);
        return root;
    }

    private void dfs(TreeNode node) {
        if (node == null) return;
        dfs(node.right);
        curr = node.val += curr;
        dfs(node.left);
    }
}
