package com.lzhlyle.leetcode.self.no226;

public class InvertBinaryTree_Recursion {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode swap = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(swap);
        return root;
    }
}
