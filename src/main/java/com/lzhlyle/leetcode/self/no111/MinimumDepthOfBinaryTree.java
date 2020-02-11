package com.lzhlyle.leetcode.self.no111;

public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int minLeft = minDepth(root.left);
        int minRight = minDepth(root.right);
        if (root.left == null) return minRight + 1;
        if (root.right == null) return minLeft + 1;
        return Math.min(minLeft, minRight) + 1;
    }
}
