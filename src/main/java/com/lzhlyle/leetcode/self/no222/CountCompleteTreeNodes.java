package com.lzhlyle.leetcode.self.no222;

public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int l = height(root.left), r = height(root.right);
        if (l == r) return countNodes(root.right) + (1 << l);
        return countNodes(root.left) + (1 << r);
    }

    // 仅需看左子树高度
    private int height(TreeNode node) {
        if (node == null) return 0;
        return height(node.left) + 1;
    }
}
