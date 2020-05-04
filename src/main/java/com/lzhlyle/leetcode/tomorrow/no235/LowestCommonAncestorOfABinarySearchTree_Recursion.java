package com.lzhlyle.leetcode.self.no235;

public class LowestCommonAncestorOfABinarySearchTree_Recursion {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int rv = root.val, pv = p.val, qv = q.val;
        if (pv > rv && qv > rv) return lowestCommonAncestor(root.right, p, q);
        else if (pv < rv && qv < rv) return lowestCommonAncestor(root.left, p, q);
        return root;
    }
}
