package com.lzhlyle.leetcode.recite.no98;

public class ValidateBinarySearchTree_Recursion {
    public boolean isValidBST(TreeNode root) {
        return _isValid(root, null, null);
    }

    private boolean _isValid(TreeNode node, Integer min, Integer max) {
        if (node == null) return true;
        int v = node.val;
        if (min != null && v <= min || max != null && v >= max) return false;
        return _isValid(node.left, min, v) && _isValid(node.right, v, max);
    }
}
