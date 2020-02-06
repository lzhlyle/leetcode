package com.lzhlyle.leetcode.tomorrow.no98;

public class ValidateBinarySearchTree_InOrder {
    private Integer last = null;

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (!isValidBST(root.left)) return false;
        if (last != null && last >= root.val) return false;
        last = root.val;
        return isValidBST(root.right);
    }
}
