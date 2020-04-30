package com.lzhlyle.leetcode.recite.no236;

public class LowestCommonAncestorOfABinaryTree_LC_DC_Recursion {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);
        if (l != null && r != null) return root; // 一个在左，一个在右，则root为lca
        return l == null ? r : l; // 都在右则r，都在左则l
    }
}
