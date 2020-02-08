package com.lzhlyle.leetcode.self.no226;

public class InvertBinaryTree_Recursion {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode swap = root.left;
        root.left = root.right;
        root.right = swap;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
