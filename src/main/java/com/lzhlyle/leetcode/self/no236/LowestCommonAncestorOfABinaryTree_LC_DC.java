package com.lzhlyle.leetcode.self.no236;

public class LowestCommonAncestorOfABinaryTree_LC_DC {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode l = lowestCommonAncestor(root.left, p, q), r = lowestCommonAncestor(root.right, p, q);
        if (l != null && r != null) return root;
        return l == null ? r : l;
    }
}
