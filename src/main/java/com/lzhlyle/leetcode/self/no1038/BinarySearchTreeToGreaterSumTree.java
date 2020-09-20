package com.lzhlyle.leetcode.self.no1038;

public class BinarySearchTreeToGreaterSumTree {
    private int curr;

    public TreeNode bstToGst(TreeNode root) {
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
