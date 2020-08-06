package com.lzhlyle.leetcode.tomorrow.no114;

public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        tail(root, null);
    }

    private TreeNode tail(TreeNode node, TreeNode parent) {
        if (node == null) return parent;
        TreeNode lt = tail(node.left, node), rt = tail(node.right, node);
        if (lt != node) {
            lt.right = node.right;
            node.right = node.left;
            node.left = null;
        }
        return rt == node ? lt : rt;
    }
}
