package com.lzhlyle.leetcode.week.no114;

public class FlattenBinaryTreeToLinkedList_LC_Recursion {
    private TreeNode pre = null;

    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.right);
        flatten(root.left);
        root.right = pre;
        root.left = null;
        pre = root;
    }
}
