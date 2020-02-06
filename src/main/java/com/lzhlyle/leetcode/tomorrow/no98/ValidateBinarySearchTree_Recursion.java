package com.lzhlyle.leetcode.tomorrow.no98;

public class ValidateBinarySearchTree_Recursion {
    public boolean isValidBST(TreeNode root) {
        return _valid(root, null, null);
    }

    private boolean _valid(TreeNode node, Integer min, Integer max) {
        if (node == null) return true;
        int val = node.val;
        if ((min != null && val <= min) || (max != null && val >= max)) return false;
        return _valid(node.left, min, val) && _valid(node.right, val, max);
    }
}
