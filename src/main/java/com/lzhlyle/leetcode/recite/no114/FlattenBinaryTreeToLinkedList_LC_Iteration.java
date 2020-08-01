package com.lzhlyle.leetcode.recite.no114;

public class FlattenBinaryTreeToLinkedList_LC_Iteration {
    public void flatten(TreeNode root) {
        while (root != null) {
            if (root.left == null) root = root.right;
            else {
                // 找左子树最右边的节点
                TreeNode tail = root.left;
                while (tail.right != null)
                    tail = tail.right;
                // process
                tail.right = root.right;
                root.right = root.left;
                root.left = null;
                // drill down
                root = root.right;
            }
        }
    }
}
